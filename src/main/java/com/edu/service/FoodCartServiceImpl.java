package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.FoodCart;
import com.edu.dao.Item;
import com.edu.error.GlobalException;
import com.edu.repository.FoodCartRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	FoodCartRepository cartRepo;
	
	@Override
	public FoodCart savecart(FoodCart foodCart) {
		// TODO Auto-generated method stub
		return cartRepo.save(foodCart);
	}

	@Override
	public FoodCart getCartById(Integer id) {
		// TODO Auto-generated method stub
		return cartRepo.findById(id).get();
	}

	@Override
	public List<FoodCart> getAllCart() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public List<Item> getItemByCartId(Integer id) throws GlobalException {
		// TODO Auto-generated method stub
		FoodCart cart = cartRepo.findById(id).get();
//		if(cart!=null) {
//			List<Item> itemList = cart.getItemList();
//			return itemList;
//		}
//		else
//			throw new GlobalException("cart with id not exist");
return null;
	}

}
