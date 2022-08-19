package com.ezen.restful.service;

import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;

// 0816
// 0817
public interface PizzaService {	
//	public Pizza getPizzaById(Pizza pizza); //0816 
//	
//	public Integer addPizza(Pizza pizza);
	
	public Pizza getPizza(int pk); //0817 °­»ç´Ô
	
	public Integer updatePizza(Pizza pizza);
	
	public Integer addPizza(Pizza pizza);
	
	// public Pizza updatePizza(int id);

}
