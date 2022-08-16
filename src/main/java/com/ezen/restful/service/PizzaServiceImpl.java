package com.ezen.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.mapper.PizzaMapper;

// 0816
@Service // ���� ������� �������� �����ذ���
public class PizzaServiceImpl implements PizzaService {
	
	@Autowired(required=false)
	PizzaMapper pizzaMapper;

	@Override
	public Pizza getPizzaById(Pizza pizza) {
		
		return pizzaMapper.getPizza(pizza);
	}

	@Override
	public Integer addPizza(Pizza pizza) {
	
		return pizzaMapper.add(pizza);
	}
	
}
