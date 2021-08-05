package com.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mock.models.FoodItem;
import com.mock.services.OrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	OrderService service;
	
	@GetMapping()
	public int getHighestOrderId()
	{
		return service.getHighestId();
	}
	
	@CrossOrigin
	@GetMapping(value="/{orderid}")
	public List<FoodItem> getOrder(@PathVariable int orderid)
	{
		return service.getOrder(orderid);
	}
	
	@PostMapping(produces="application/json",consumes="application/json")
	public ResponseEntity<List<FoodItem>> addOrderItems(@RequestBody @Validated List<FoodItem> food)
	{
		return new ResponseEntity<>(service.addOrderItems(food),HttpStatus.CREATED);
	}
}
