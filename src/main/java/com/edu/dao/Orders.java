package com.edu.dao;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ordersid;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ordersdate;
	
	//edit
	@PrePersist
	private void onCreate() {
		ordersdate = new Date();
	}
	
	
	@NotEmpty(message = "Please enter order status")
	@NotBlank(message = "Please enter order status")
	@Column(nullable = false)
	private String ordersstatus;


	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Orders(String ordersstatus) {
		super();
		this.ordersstatus = ordersstatus;
	}


	public Integer getOrdersid() {
		return ordersid;
	}


	public void setOrdersid(Integer ordersid) {
		this.ordersid = ordersid;
	}


	public Date getOrdersdate() {
		return ordersdate;
	}


	public void setOrdersdate(Date ordersdate) {
		this.ordersdate = ordersdate;
	}


	public String getOrdersstatus() {
		return ordersstatus;
	}


	public void setOrdersstatus(String ordersstatus) {
		this.ordersstatus = ordersstatus;
	}


	@Override
	public String toString() {
		return "Orders [ordersid=" + ordersid + ", ordersdate=" + ordersdate + ", ordersstatus=" + ordersstatus + "]";
	}
	
	
}
