package com.ezen.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.service.PizzaService;

import lombok.extern.log4j.Log4j2;

//0816 restcontroller

@Log4j2
//@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST})
@RestController
public class PizzaRestController {

	@Autowired//(required=false)
	PizzaService service;
	
	// GET방식으로 피자의 ID와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환
	
	
//	@GetMapping(value="/getid", produces=MediaType.APPLICATION_JSON_VALUE)	
//	public Pizza getPizza(@RequestBody Pizza pizza){
//		Integer id = 3;
//		//Pizza pizza = service.getPizzaById(new Pizza(2,null,0,0.0));
//		
//		return service.getPizzaById(pizza);
//	}
	
	// POST방식으로 파라미터의 피자 데이터와 함께 요청 보내면 해당 피자를 DB에 추가
	
//	@PostMapping(value="/addpizza", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Integer insertPizza1(@RequestBody Pizza pizza) {
//		
//		return service.addPizza(pizza);
//	}
	
	// @RestController에서는 @RequestBody를 적어주지 않으면 파라미터가 자동 바인딩 되지 않는다
	//@PostMapping(value = "/sample/pizza")
//	@RequestMapping(value = "/sample/pizza", method=RequestMethod.POST)
//	public Integer insertPizza(@RequestBody Pizza pizza) {
//		return 1;
//	}
//	
	// PUT방식으로 파라미터에 피자 데이터를 함께 요청을 보내면 해당 피자의 정보를 받아서 수정
	
	// DELETE 방식으로 피자의 ID와 함께 요청을 보내면 해당 피자를 DB에서 삭제
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	// 0817 강사님 풀이
	@GetMapping(value="/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // pizza 뒤에 id 를 넣으면 해당 id의 피자가 나온다
	public Pizza getPizza(@PathVariable Integer id){
		
		// 피자의 조회수(칼로리)가 있고 조회할때마다 1씩 증가한다고 가정
		return service.getPizza(id);
	}
	
	// 0818 insert
//	@PostMapping(value="/sample/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Integer insertPizza(@RequestBody Pizza pizza) {
//		log.info("pizza info : " + pizza);
//		return service.addPizza(pizza);
//	}
	
	//0819 강사님 insert
	@PostMapping(value="/sample/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pizza> insertPizza(@RequestBody Pizza pizza) {
		
		if(pizza.getName() == null || pizza.getName().trim().equals("")|| pizza.getCalrories() == null || pizza.getPrice() == null) { // null값 뿐만 아니라 없는 값 빈값도 검증해야한다
			return ResponseEntity.badRequest().build();
		}
		
		try {
			service.addPizza(pizza);
			
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		// ResponseEntity : 상황에 따라 원하는 응답을 만들 수 있다. (상태 코드 활용 100번대 부터 500번대 까지)
		//ResponseEntity<Pizza> response = null;
		
		// RseponseEntity.ok() : Http 상태코드 200의 응답을 만든다. 응답안에 화물을 실을수 있다
		//response = ResponseEntity.ok(null);
		
		// RseponseEntity.notFound() : Http 상태코드 404의 응답을 만든다.
		//response = ResponseEntity.notFound().build();
		
		// 자유롭게 응답만들기
		//response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(service.getPizza(3));
		
		//return response;
		
		
	}


	
	@PutMapping(value="/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE) // row가 Integer1Integer로 응답하기 떄문에 text plain으로 보ㅓ내준다
	public String updatePizza(@RequestBody Pizza pizza) {
		//log.info("받은 피자:" + pizza);
		try {
			return service.updatePizza(pizza).toString();
		}catch(Exception e) {
			return "0 : " + e;
		}
		
	}
	
	@DeleteMapping(value="/sample/pizza/{id}")
	public Integer deletePizza() {
		return 4;
	}
	
}
