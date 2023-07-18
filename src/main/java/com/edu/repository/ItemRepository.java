package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findItemByitemname(String itemname);

	@Query(value="select * from item where restid=:restid",nativeQuery = true)
	List<Item> getItemByRestId(Integer restid);
	
}
