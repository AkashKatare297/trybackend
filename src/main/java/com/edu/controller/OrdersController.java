package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Orders;
import com.edu.error.GlobalException;
import com.edu.service.OrdersService;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService ordersService; 
	
	@PostMapping("/enterOrder")
	public ResponseEntity<Orders> enterOrder(@Valid @RequestBody Orders orders){
		
		Orders ors = ordersService.enterOrder(orders);
		
		return new ResponseEntity<Orders>(ors, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllOrders")
	public List<Orders> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	@GetMapping("/getOrdersById/{oid}")
	public Orders getOrdersById(@PathVariable("oid") Integer ordersid) throws GlobalException {
		return ordersService.getOrdersById(ordersid);
	}
	
	@PutMapping("/updateOrdersById/{oid}")
	public Orders updateOrdersById(@PathVariable("oid") Integer ordersid, @Valid @RequestBody Orders orders) throws GlobalException {
		return ordersService.updateOrdersById(ordersid,orders);
	}
	
	@DeleteMapping("/deleleOrdersById/{oid}")
	public String deleleOrdersById(@PathVariable("oid") Integer ordersid) throws GlobalException {
		ordersService.deleleOrdersById(ordersid);
		
		return "record deleted";
	}
}
