package com.ezen.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;

import lombok.extern.log4j.Log4j;

//0816 rest��Ʈ�ѷ� ������

@Log4j
@RestController
public class RestSampleController {
	
	@GetMapping(value="/test1", produces = "text/plain; charset=EUC-KR")
	public String test1() {
		return "Hello, RESTFUL!";
	}
	
	// jackson-databind : �ڹ� ��ü�� JSONŸ�� �Ǵ� XMLŸ������ �˾Ƽ� ��ȯ���ִ� ���̺귯��
	
	@GetMapping(value="/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("���۷δ�");
		pizza.setCalrories(123.12);
		pizza.setPrice(8000);
		return pizza;
	}
	
	@GetMapping(value="/pizza2", produces = MediaType.APPLICATION_XML_VALUE)
	public Pizza getPizza2() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("pepporoni");
		pizza.setCalrories(123.12);
		pizza.setPrice(8000);
		return pizza;
	}

	@GetMapping(value="/pizzas", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pizza> getPizzas(){
		List<Pizza> pizzas = new ArrayList<>();
		
		pizzas.add(new Pizza(1001, "���ξ��� ����", 12000, 1560.8));
		pizzas.add(new Pizza(1002, "��Ʈ���� ����", 11000, 4560.8));
		pizzas.add(new Pizza(1003, "���۹�Ʈ ����", 13000, 3560.8));
		pizzas.add(new Pizza(1004, "���� ����", 14000, 2560.8));
		
		return pizzas;
	}
	
	@GetMapping(value="/pizza_map", produces= MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Pizza> getPizzaMap(){
		Map<String, Pizza> pizzaMap = new HashMap<>();
		
		pizzaMap.put("menu1",new Pizza(1001, "���ξ��� ����", 12000, 1560.8));
		pizzaMap.put("menu2",new Pizza(1003, "���۹�Ʈ ����", 13000, 3560.8));
		pizzaMap.put("menu3",new Pizza(1004, "���� ����", 14000, 2560.8));
		
		
		
		return pizzaMap;
	}
}
