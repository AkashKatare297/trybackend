package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.dao.Orders;
import com.edu.error.GlobalException;

public interface OrdersService {

	public Orders enterOrder(@Valid Orders orders);

	public List<Orders> getAllOrders();

	public Orders getOrdersById(Integer ordersid) throws GlobalException;

	public Orders updateOrdersById(Integer ordersid, @Valid Orders orders) throws GlobalException ;

	public void deleleOrdersById(Integer ordersid) throws GlobalException ;


}
