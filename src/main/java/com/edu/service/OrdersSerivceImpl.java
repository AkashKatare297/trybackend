package com.edu.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Orders;
import com.edu.error.GlobalException;
import com.edu.repository.OrdersRepository;

@Service
public class OrdersSerivceImpl implements OrdersService {
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders enterOrder(Orders orders) {
		// TODO Auto-generated method stub
		return ordersRepository.save(orders);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return ordersRepository.findAll();
	}

	@Override
	public Orders getOrdersById(Integer ordersid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Orders> obj = ordersRepository.findById(ordersid);
		
		if(!obj.isPresent())
			throw new GlobalException("order id "+ordersid+" is not found");
		else
			return ordersRepository.findById(ordersid).get();
		
	}

	@Override
	public Orders updateOrdersById(Integer ordersid, @Valid Orders orders) throws GlobalException  {
		// TODO Auto-generated method stub
		
		Orders ob = null;
		Optional<Orders> obj = ordersRepository.findById(ordersid);
		
		if(!obj.isPresent())
			throw new GlobalException("order id "+ordersid+" is not present");
		else {
			ob = ordersRepository.findById(ordersid).get();
			
			ob.setOrdersstatus(orders.getOrdersstatus());
			
			return ordersRepository.save(ob);
		}
			
	}

	@Override
	public void deleleOrdersById(Integer ordersid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Orders> obj = ordersRepository.findById(ordersid);
		
		if(!obj.isPresent())
			throw new GlobalException("order id "+ordersid+" is not present");
		else
			ordersRepository.deleteById(ordersid);
	}

	
}
