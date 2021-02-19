package com.ntuc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class location {

	@Id
	@Column(length = 10, nullable = false)
	private Integer locid;
	
	@Column(length = 40)
	private String address;
	@Column(length = 12)
	private String postal;
	@Column(length = 30)
	private String city;
	@Column(length = 25)
	private String state;
	@Column(length=2,unique=true)
	private String cntryid;
	
	public location(Integer locid, String address, String postal, String city, String state, String cntryid) {
		super();
		this.locid = locid;
		this.address = address;
		this.postal = postal;
		this.city = city;
		this.state = state;
		this.cntryid = cntryid;
	}
	public location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getLocid() {
		return locid;
	}
	public void setLocid(Integer locid) {
		this.locid = locid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCntryid() {
		return cntryid;
	}
	public void setCntryid(String cntryid) {
		this.cntryid = cntryid;
	}
	@Override
	public String toString() {
		return "location [locid=" + locid + ", address=" + address + ", postal=" + postal + ", city=" + city
				+ ", state=" + state + ", cntryid=" + cntryid + "]";
	}
	
	
	
}
