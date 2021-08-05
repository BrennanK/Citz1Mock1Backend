package com.mock.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mock.models.FoodItem;

@Repository
public interface OrderRepository extends JpaRepository<FoodItem,Integer> 
{
	@Query("Select MAX(orderid) from FoodItem")
	public int getMaxOrderid();
	
	public List<FoodItem> getFoodItemByOrderid(int orderId);
	
}
