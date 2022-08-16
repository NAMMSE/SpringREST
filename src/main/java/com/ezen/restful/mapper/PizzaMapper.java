package com.ezen.restful.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

//0816
public interface PizzaMapper {

	public List<Pizza> getAll();
	
	public int getIdByName(Pizza pizza); // id�� ������ �ش� id�� �̸��� �����´�

	public int add(Pizza pizza);
	
	public Pizza getPizza(Pizza pizza); // id�� ������ �ش� ������ ������ �����´�

	public Integer update(Pizza pizza);
}
