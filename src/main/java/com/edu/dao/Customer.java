package com.edu.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerid;
	//@NotNull(message = "Enter Customer Name") 
	@Column(nullable = false)
	private String customername;
	//@NotNull(message = "Enter Customer Mobile Number") 
	@Column(length = 10 ,  nullable = false)
	private long customermobilenumber;

	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid Email")
	//@NotNull(message = "Enter Customer Email Id") 
	//@Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}" , message = "invalid Email")
	@Column(unique = true)
	private String customeremail;
	
	//@NotNull(message = "Enter password")
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "enter proper password")
	private String password;
	
	@OneToMany(mappedBy="cust")
	Set<CustomerAddress> cob = new HashSet<CustomerAddress>();
	
	
	
	
	public Set<CustomerAddress> getCob() {
		return cob;
	}

	public void setCob(Set<CustomerAddress> cob) {
		this.cob = cob;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customername,long customermobilenumber,String customeremail, String password) {
		super();
		this.customername = customername;
		this.customermobilenumber = customermobilenumber;
		this.customeremail = customeremail;
		this.password = password;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public long getCustomermobilenumber() {
		return customermobilenumber;
	}

	public void setCustomermobilenumber(long customermobilenumber) {
		this.customermobilenumber = customermobilenumber;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customermobilenumber="
				+ customermobilenumber + ", customeremail=" + customeremail + ", password=" + password + ", cob=" + cob
				+ "]";
	}
	
	

}
