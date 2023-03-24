package com.java.jsfHib;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name = "cDao")
@SessionScoped
public class CompanyDaoImpl implements CompanyDAO{
	
	// Temporary Storing Strings
	
	private String companyName;
	private String companyId;


	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	// Method to Show Only company Names
	
	@Override
	public List<Company> showCompanyNames() {
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		cr.setProjection(Projections.distinct(Projections.property("companyName")));
		List<Company> companyNames = cr.list();
		return companyNames;
	}
	

	// Method to search the company by name to get Id.
	
	public String searchCompanyToGetId(String companyName)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		cr.add(Restrictions.eq("companyName", companyName));
		Projection projection = Projections.property("companyId"); 
		cr.setProjection(projection); 
		String cid = (String) cr.uniqueResult();
		return cid;
	}
	
	//Method to get company Address
	
	public String getCompanyAddress(String cId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		Projection projection = Projections.property("address");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("companyId", cId));
		String address = (String) cr.uniqueResult();
		return address;
	}
	
	//Method to get company mobile
	
	public String getMobile(String cId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		Projection projection = Projections.property("contact");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("companyId", cId));
		String mobile = (String) cr.uniqueResult();
		return mobile;
	}
	
	//Method to get company email
	
	public String getMail(String cId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		Projection projection = Projections.property("email");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("companyId", cId));
		String email = (String) cr.uniqueResult();
		return email;
	}
	
	//Method to get company Website.
	
	public String getWebSite(String cId)
	{
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Company.class);
		Projection projection = Projections.property("website");
		cr.setProjection(projection);
		cr.add(Restrictions.eq("companyId", cId));
		String webSite = (String) cr.uniqueResult();
		return webSite;
	}
	
	//Value change Event
	
	public void companyLocalCodeChange(ValueChangeEvent e)
	{
		Map<String,Object> sessionMap = 
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();		
		String cName = e.getNewValue().toString();
		if(cName.equals("---Select Company---"))
		{
			FacesContext.getCurrentInstance().addMessage("companyName", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Select Company", null));
		}else {
		String cId = searchCompanyToGetId(cName);
		this.companyId=cId;
		this.companyName = cName;
		System.out.println(this.companyName);
		sessionMap.put("companyId", this.companyId);
		}
	}
}


