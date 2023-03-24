package com.java.jsfHib;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
@ManagedBean
@SessionScoped
public class Company {
	
	@Id
	@Column(name = "I_COMPANY_ID")
	private String companyId; 
	@Column(name = "I_COMPANY_NAME")
	private String companyName;
	@Column(name = "I_ADDRESS")
	private String address;
	@Column(name = "I_CONTACT")
	private String contact;
	@Column(name = "I_EMAIL")
	private String email;
	@Column(name = "I_WEBSITE")
	private String website;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", website=" + website + "]";
	}
	
	
			
	
	
	

}
