package com.ezen.restful.service;

import java.util.List;

import com.ezen.restful.dto.Pizza;

// 0816

public interface PizzaService {	
	public Pizza getPizzaById(Pizza pizza); //0816 
	
	public Integer addPizza(Pizza pizza);

}
