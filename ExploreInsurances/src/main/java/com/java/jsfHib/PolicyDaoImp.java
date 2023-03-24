package com.java.jsfHib;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "Dao")
@SessionScoped
public class PolicyDaoImp {

	
	private String policyType;
	private String policyId;
	private String policyName;

	

	public String getPolicyName() {
		return policyName;
	}


	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}


	public String getPolicyType() {
		return policyType;
	}


	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}


	public String getPolicyId() {
		return policyId;
	}


	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	
	
	//Method to search the Policy type with name,id and policyTpe
	
	public String searchPolicyByTypeToGetId(String policyName, String companyId, String policyType)
	{
	
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		cr.add(Restrictions.eq("planName", this.policyName ));
		cr.add(Restrictions.eq("cId", companyId));
		cr.add(Restrictions.eq("planType", policyType));
		Projection projection = Projections.property("planId");
		cr.setProjection(projection);
		String pId = (String) cr.uniqueResult();
		return pId;
	}

	//method to get keyBenifits of policy

	public String getPolicyDetails(String pId) {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("keyBenifits");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		String s = (String) cr.uniqueResult();
		
		return s;
	}
	
	//Method to get Basic premium

	public Double getPremium(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("premium");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		Double d = (Double) cr.uniqueResult();
		return d;
	}
	
	//Method to get coverage of Insurance age above 60
	
	public double getCoverageAbove60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("coverageAbove60");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double coverage = (double) cr.uniqueResult();
		return coverage;
	} 
	
	//Method to get coverage of Insurance age below 18
	
	public double getCoverageBelow18(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("coveragebelow18");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double coverage = (double) cr.uniqueResult();
		return coverage;
	} 
	
	//Method to get coverage of Insurance age b/w 18-60
	
	public double getCoverageBtw18And60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("coverage18to60");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double coverage = (double) cr.uniqueResult();
		return coverage;
	} 
	
	//Method to get Active status
	
//	public String getPolicyStatus(String pId)
//	{
//		SessionFactory sf = SessionHelper.getConnection();
//		Session session = sf.openSession();
//		Criteria cr = session.createCriteria(Policy.class);
//		Projection projection = Projections.property("status");
//		cr.setProjection(projection);
//		cr.add(Restrictions.eq("planId", pId));
//		String s = (String) cr.uniqueResult();
//		return s;
//	}
	
	//Method to get premium id by policy id.
	
	public String getpremIdByPolicyId(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("premId");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		String premId = (String) cr.uniqueResult();
		return premId;
	}
	
	//Method to get premium for above 60 age by premium id.
	
	public double getPremiumAbove60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("prem60above");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium;
	}
	
	//Method to get premium for between 18 to 60 age by premium id.
	
	public double getPremium18To60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("prem18to60");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium;
	}
	
	//Method to get premium for below 18 age by premium id.
	
	public double getPremiumBelow18(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("prem18below");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium;
	}
	
	//Method to get Discount for 18 to 16 age by premium id.
	
	public double getDiscount18To60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("disc_18to60");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium; 
	}
	
	//Method to get Discount for above 60 age by premium id.
	
	public double getDiscountAbove60(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("disc_above_60");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium; 
	}
	
	//Method to get Discount for below 18 age by premium id.
	
	public double getDiscountBelow18(String pId)
	{
		String premId = getpremIdByPolicyId(pId);
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Premium.class);
		Projection projection = Projections.property("disc_below_18");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("premId", premId));
		double premium = (double) cr.uniqueResult();
		return premium; 
	}
	
	
	// Method to get Expire Date of policy by premium id.
	
	public Date getExpiryDate(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("expiryDate");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		Date date = (Date) cr.uniqueResult();
		return date;
	}
	
	// Method to get Launch Date of policy by premium id.
	
	public Date launchDate(String pId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.property("launchDate");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("planId", pId));
		Date date = (Date) cr.uniqueResult();
		return date;
	}

	
	//Method to show policy Types by the selected policy Name.

	public List<Policy> showPolicyTypesByPolicyName()
	{
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.distinct(Projections.property("planType")); 
		cr.setProjection(projection); 
		String Id = (String) sessionMap.get("companyId");
		cr.add(Restrictions.eq("cId", Id));
		cr.add(Restrictions.eq("planName", this.policyName));
		List<Policy> list = cr.list();
		return list;
	}
	
	//Method to show the Policy Names By the Company Id.
	
	public List<Policy> showPolicyNamesByCompId()
	{
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Policy.class);
		Projection projection = Projections.distinct(Projections.property("planName")); 
		cr.setProjection(projection); 
		String Id = (String) sessionMap.get("companyId");
		cr.add(Restrictions.eq("cId", Id));
		List<Policy> list = cr.list();
		return list;
	}

	//Method to Submit the selected policy names and types. 
	
	public String submitPolicy() throws IOException {

		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String cId = (String) sessionMap.get("companyId");
		String s = searchPolicyByTypeToGetId(this.policyName,cId,this.policyType);
		this.policyId=s;
		System.out.println("PolicyId" +this.policyId);
		return "KeyBenifitsDummy.xhtml?faces-redirect=true";
	}
	
	//Just to return the Do's and Don'ts
	
	public String dosAndDonts()
	{
		return "Do'sAndDont's.xhtml?faces-redirect=true";
	}
	
	//Value change Event Lister
	
	public void policyChangeEvent(ValueChangeEvent e)
	{
		String pName = e.getNewValue().toString();
		this.policyName= pName;
		
	}
	
	public void reset()
	{
		CompanyDaoImpl impl = new CompanyDaoImpl();
		this.policyName="---select policy---";
		this.policyType="";
		impl.setCompanyName("---Select Company---");
		//return "Footer1.xhtml?faces-redirect=true";
	}
	
	

}

