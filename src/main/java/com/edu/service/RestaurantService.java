package com.edu.service;

import java.util.List;


import javax.validation.Valid;

import com.edu.dao.Item;
import com.edu.dao.Restaurant;
import com.edu.error.GlobalException;

public interface RestaurantService{

	public Restaurant saveRestaurant(Restaurant restaurant);

	public List<Restaurant> getAllRestaurant();

	public void deleteRestaurantById(Integer restid) throws GlobalException;

	public Restaurant updateRestaurantById(Integer restid, Restaurant restaurant) throws GlobalException;

	public Restaurant saveItemByRestIdi(@Valid Item item, Integer restid) throws GlobalException;

//	public Restaurant findRestaurantByName(String restname) throws GlobalException;
//
//	public Restaurant updateRestaurantManagerName(@Valid Integer id, @Valid String managerName) throws GlobalException;

	

}
