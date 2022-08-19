package com.ezen.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.mapper.PizzaMapper;

// 0816
@Service // ���� ������� �������� �����ذ���
public class PizzaServiceImpl implements PizzaService {
	
	/*
	 	# Mapper Interface
	 	
	 	 - ��ݸ� �ۼ��س����� MyBatis�� �ڵ����� �ش� �������̽��� ����ü�� �����Ѵ�
	 	 - �˾Ƽ� ������ jdbc �ڵ带 �ڵ����� ������ �� mybatis-spring:scan�� ���� spring-context�� ��ϵȴ�
	 */
	
	@Autowired//(required=false)
	PizzaMapper pizzaMapper; // ���⿡ jdbc ����ü�� ���´�

//	@Override
//	public Pizza getPizzaById(Pizza pizza) {
//		
//		return pizzaMapper.getPizza(pizza);
//	}
//
//	@Override
//	public Integer addPizza(Pizza pizza) {
//	
//		return pizzaMapper.add(pizza);
//	}
//	
	///////0817 �����
	@Override
	public Pizza getPizza(int pk) {
		pizzaMapper.updateView(pk);
		
		return pizzaMapper.get(pk);
	}

	@Override
	public Integer updatePizza(Pizza pizza) {
		return pizzaMapper.update(pizza);
	}

	@Override
	public Integer addPizza(Pizza pizza) {
		return pizzaMapper.addPizza(pizza);
	}
	
//	@Override
//	public Pizza updatePizza(int id) {
//		return pizzaMapper.updatePizza(pizza);
//	}
	
}
