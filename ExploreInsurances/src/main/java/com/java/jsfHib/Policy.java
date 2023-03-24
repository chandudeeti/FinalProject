package com.java.jsfHib;

import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ManagedBean
@Table(name = "insurance")
@SessionScoped
public class Policy {
	@Id
	@Column(name = "I_PLAN_ID")
	private String planId;
	@Column(name = "I_COMPANY_ID")
	private String cId;
	
	@Column(name = "I_EXPIRY_DATE")
	private Date expiryDate;
	@Column(name = "I_LAUNCH_DATE")
	private Date launchDate;
	@Column(name = "I_PLAN_NAME")
	private String planName;
	@Column(name = "I_PLAN_TYPE")
	private String planType;
	@Column(name = "I_PREMIUM")
	private double premium;
	@Column(name = "I_STATUS")
	private String status;
	@Column(name = "I_KEY_BENIFITS")
	private String keyBenifits;
	@Column(name = "I_PREM_FK")
	private String premId;
	@Column(name = "I_COVERAGE_18TO60")
	private double coverage18to60;
	@Column(name = "I_COVERAGE_ABOVE60")
	private double coverageAbove60;
	@Column(name = "I_COVERAGE_BELOW18")
	private double coveragebelow18;
	
	
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Date getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKeyBenifits() {
		return keyBenifits;
	}
	public void setKeyBenifits(String keyBenifits) {
		this.keyBenifits = keyBenifits;
	}
	public String getPremId() {
		return premId;
	}
	public void setPremId(String premId) {
		this.premId = premId;
	}
	public double getCoverage18to60() {
		return coverage18to60;
	}
	public void setCoverage18to60(double coverage18to60) {
		this.coverage18to60 = coverage18to60;
	}
	public double getCoverageAbove60() {
		return coverageAbove60;
	}
	public void setCoverageAbove60(double coverageAbove60) {
		this.coverageAbove60 = coverageAbove60;
	}
	public double getCoveragebelow18() {
		return coveragebelow18;
	}
	public void setCoveragebelow18(double coveragebelow18) {
		this.coveragebelow18 = coveragebelow18;
	}
	
	
	@Override
	public String toString() {
		return "Policy [planId=" + planId + ", cId=" + cId + ", expiryDate=" + expiryDate + ", launchDate=" + launchDate
				+ ", planName=" + planName + ", planType=" + planType + ", premium=" + premium + ", status=" + status
				+ ", keyBenifits=" + keyBenifits + ", premId=" + premId + ", coverage18to60=" + coverage18to60
				+ ", coverageAbove60=" + coverageAbove60 + ", coveragebelow18=" + coveragebelow18 + "]";
	}
	
	
	
	
	
}
	
	