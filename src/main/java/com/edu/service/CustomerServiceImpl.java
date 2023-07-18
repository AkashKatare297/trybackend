package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Customer;
import com.edu.repository.CustomerRepository;
import com.edu.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	

	@Override
	public void deleteCustomerById(Integer customerid) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerid);
	}


	@Override
	public Customer updateCustomerById(Integer customerid, @Valid Customer customer) {
		// TODO Auto-generated method stub
		Customer cus = customerRepository.findById(customerid).get();
		if(cus!=null) {
			cus.setCustomername(customer.getCustomername());
			cus.setCustomermobilenumber(customer.getCustomermobilenumber());
			cus.setCustomeremail(customer.getCustomeremail());
			cus.setPassword(customer.getPassword());
			customerRepository.save(cus);
		}
		return cus;
	}

	@Override
	public List<Customer> findByCustomernameAndCustomerpassword(String cname, String cpass) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomernameAndCustomerpassword(cname, cpass);
	}

	@Override
	public Customer getCustomerByEmail(String email,String password) {
		// TODO Auto-generated method stub
		return customerRepository.getCustomerByEmail(email,password);
	}



}
