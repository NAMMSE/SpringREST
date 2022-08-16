package com.ezen.restful.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

//0816
public interface PizzaMapper {

	public List<Pizza> getAll();
	
	public int getIdByName(Pizza pizza); // id를 보내고 해당 id의 이름을 가져온다

	public int add(Pizza pizza);
	
	public Pizza getPizza(Pizza pizza); // id를 보내고 해당 피자의 정보를 가져온다

	public Integer update(Pizza pizza);
}
