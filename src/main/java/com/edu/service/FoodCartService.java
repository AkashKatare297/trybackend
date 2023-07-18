package com.edu.service;

import java.util.List;

import com.edu.dao.FoodCart;
import com.edu.dao.Item;
import com.edu.error.GlobalException;

public interface FoodCartService {

	FoodCart savecart(FoodCart foodCart);

	FoodCart getCartById(Integer id);

	List<FoodCart> getAllCart();

	List<Item> getItemByCartId(Integer id) throws GlobalException;

}
