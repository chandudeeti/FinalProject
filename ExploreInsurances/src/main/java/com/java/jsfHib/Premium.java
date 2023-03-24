package com.java.jsfHib;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ManagedBean
@SessionScoped
@Table(name = "premium")
@Entity
public class Premium {
	@Id
	@Column(name = "I_PREMIUM_ID")
	private String premId;
	@Column(name = "I_DISC_18TO60")
	private double disc_18to60;
	@Column(name = "I_DISC_ABOVE60")
	private double disc_above_60;
	@Column(name = "I_DISC_BELOW18")
	private double disc_below_18;
	@Column(name = "I_PREMIUM_18TO60")
	private double prem18to60;
	@Column(name = "I_PRMEIUM_ABOVE60")
	private double prem60above;
	@Column(name = "I_PREMIUM_BELOW_18")
	private double prem18below;
	
	public String getPremId() {
		return premId;
	}
	public void setPremId(String premId) {
		this.premId = premId;
	}
	public double getDisc_18to60() {
		return disc_18to60;
	}
	public void setDisc_18to60(double disc_18to60) {
		this.disc_18to60 = disc_18to60;
	}
	public double getDisc_above_60() {
		return disc_above_60;
	}
	public void setDisc_above_60(double disc_above_60) {
		this.disc_above_60 = disc_above_60;
	}
	public double getDisc_below_18() {
		return disc_below_18;
	}
	public void setDisc_below_18(double disc_below_18) {
		this.disc_below_18 = disc_below_18;
	}
	public double getPrem18to60() {
		return prem18to60;
	}
	public void setPrem18to60(double prem18to60) {
		this.prem18to60 = prem18to60;
	}
	public double getPrem60above() {
		return prem60above;
	}
	public void setPrem60above(double prem60above) {
		this.prem60above = prem60above;
	}
	public double getPrem18below() {
		return prem18below;
	}
	public void setPrem18below(double prem18below) {
		this.prem18below = prem18below;
	}
	@Override
	public String toString() {
		return "Premium [premId=" + premId + ", disc_18to60=" + disc_18to60 + ", disc_above_60=" + disc_above_60
				+ ", disc_below_18=" + disc_below_18 + ", prem18to60=" + prem18to60 + ", prem60above=" + prem60above
				+ ", prem18below=" + prem18below + "]";
	}
	
	
	
	

}
