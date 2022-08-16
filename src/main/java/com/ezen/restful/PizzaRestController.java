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
	
	// GET방식으로 피자의 ID와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환
	
	
	@GetMapping(value="/getid", produces=MediaType.APPLICATION_JSON_VALUE)	
	public Pizza getPizza(@RequestBody Pizza pizza){
		Integer id = 3;
		//Pizza pizza = service.getPizzaById(new Pizza(2,null,0,0.0));
		
		return service.getPizzaById(pizza);
	}
	
	// POST방식으로 파라미터의 피자 데이터와 함께 요청 보내면 해당 피자를 DB에 추가
	
	@PostMapping(value="/addpizza", produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer insertPizza1(@RequestBody Pizza pizza) {
		
		return service.addPizza(pizza);
	}
	
	// @RestController에서는 @RequestBody를 적어주지 않으면 파라미터가 자동 바인딩 되지 않는다
	@PostMapping(value = "/sample/pizza")
	@RequestMapping(value = "/sample/pizza", method=RequestMethod.POST)
	public Integer insertPizza(@RequestBody Pizza pizza) {
		return 1;
	}
	
	// PUT방식으로 파라미터에 피자 데이터를 함께 요청을 보내면 해당 피자의 정보를 받아서 수정
	
	// DELETE 방식으로 피자의 ID와 함께 요청을 보내면 해당 피자를 DB에서 삭제
	
}
