package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.dao.FoodCart;

public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{ 

}
