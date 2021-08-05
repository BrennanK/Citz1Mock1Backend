package com.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.models.FoodItem;
import com.mock.repositories.OrderRepository;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepository rep;
	
	public int getHighestId()
	{
		return rep.getMaxOrderid();
	}
	
	public List<FoodItem> getOrder(int orderid)
	{
		return rep.getFoodItemByOrderid(orderid);
	}
	
	public List<FoodItem> addOrderItems(List<FoodItem> food)
	{
		return rep.saveAll(food);
	}
}
