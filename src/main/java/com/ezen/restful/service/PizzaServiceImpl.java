package com.ezen.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.mapper.PizzaMapper;

// 0816
@Service // 서비스 적어줘야 스프링이 수거해간다
public class PizzaServiceImpl implements PizzaService {
	
	/*
	 	# Mapper Interface
	 	
	 	 - 골격만 작성해놓으면 MyBatis가 자동으로 해당 인터페이스의 구현체를 생성한다
	 	 - 알아서 귀찮은 jdbc 코드를 자동으로 생성한 후 mybatis-spring:scan을 통해 spring-context에 등록된다
	 */
	
	@Autowired//(required=false)
	PizzaMapper pizzaMapper; // 여기에 jdbc 구현체가 들어온다

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
	///////0817 강사님
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
