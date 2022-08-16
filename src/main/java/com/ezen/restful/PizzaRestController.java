package com.ezen.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.service.PizzaService;

//0816 restcontroller

@RequestMapping(value="/pizzarest" , method= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
public class PizzaRestController {

	@Autowired(required=false)
	PizzaService service;
	
	// GET������� ������ ID�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	
	
	@GetMapping(value="/getid", produces=MediaType.APPLICATION_JSON_VALUE)	
	public Pizza getPizza(@RequestBody Pizza pizza){
		Integer id = 3;
		//Pizza pizza = service.getPizzaById(new Pizza(2,null,0,0.0));
		
		return service.getPizzaById(pizza);
	}
	
	// POST������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� DB�� �߰�
	
	@PostMapping(value="/addpizza", produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer insertPizza1(@RequestBody Pizza pizza) {
		
		return service.addPizza(pizza);
	}
	
	// @RestController������ @RequestBody�� �������� ������ �Ķ���Ͱ� �ڵ� ���ε� ���� �ʴ´�
	@PostMapping(value = "/sample/pizza")
	@RequestMapping(value = "/sample/pizza", method=RequestMethod.POST)
	public Integer insertPizza(@RequestBody Pizza pizza) {
		return 1;
	}
	
	// PUT������� �Ķ���Ϳ� ���� �����͸� �Բ� ��û�� ������ �ش� ������ ������ �޾Ƽ� ����
	
	// DELETE ������� ������ ID�� �Բ� ��û�� ������ �ش� ���ڸ� DB���� ����
	
}
