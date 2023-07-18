package com.edu.service;

import java.util.List;


import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.edu.dao.Item;
import com.edu.error.GlobalException;


public interface ItemService {

	public Item saveItem(Item item);

	public List<Item> getAllItems();

	public void deleteItemById(Integer itemid) throws GlobalException;

	public Item updateItemById(Integer itemid, Item item) throws GlobalException;

	public Item itemAssignedRestaurant(Integer itemid, Integer restid);

	public List<Item> getItemByRestId(Integer restid);

	public Item saveItemByRestId(@Valid Item item, Integer restid) throws GlobalException;


}

