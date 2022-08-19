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
	
	// GET������� ������ ID�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	
	
//	@GetMapping(value="/getid", produces=MediaType.APPLICATION_JSON_VALUE)	
//	public Pizza getPizza(@RequestBody Pizza pizza){
//		Integer id = 3;
//		//Pizza pizza = service.getPizzaById(new Pizza(2,null,0,0.0));
//		
//		return service.getPizzaById(pizza);
//	}
	
	// POST������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� DB�� �߰�
	
//	@PostMapping(value="/addpizza", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Integer insertPizza1(@RequestBody Pizza pizza) {
//		
//		return service.addPizza(pizza);
//	}
	
	// @RestController������ @RequestBody�� �������� ������ �Ķ���Ͱ� �ڵ� ���ε� ���� �ʴ´�
	//@PostMapping(value = "/sample/pizza")
//	@RequestMapping(value = "/sample/pizza", method=RequestMethod.POST)
//	public Integer insertPizza(@RequestBody Pizza pizza) {
//		return 1;
//	}
//	
	// PUT������� �Ķ���Ϳ� ���� �����͸� �Բ� ��û�� ������ �ش� ������ ������ �޾Ƽ� ����
	
	// DELETE ������� ������ ID�� �Բ� ��û�� ������ �ش� ���ڸ� DB���� ����
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	// 0817 ����� Ǯ��
	@GetMapping(value="/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) // pizza �ڿ� id �� ������ �ش� id�� ���ڰ� ���´�
	public Pizza getPizza(@PathVariable Integer id){
		
		// ������ ��ȸ��(Į�θ�)�� �ְ� ��ȸ�Ҷ����� 1�� �����Ѵٰ� ����
		return service.getPizza(id);
	}
	
	// 0818 insert
//	@PostMapping(value="/sample/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Integer insertPizza(@RequestBody Pizza pizza) {
//		log.info("pizza info : " + pizza);
//		return service.addPizza(pizza);
//	}
	
	//0819 ����� insert
	@PostMapping(value="/sample/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pizza> insertPizza(@RequestBody Pizza pizza) {
		
		if(pizza.getName() == null || pizza.getName().trim().equals("")|| pizza.getCalrories() == null || pizza.getPrice() == null) { // null�� �Ӹ� �ƴ϶� ���� �� �󰪵� �����ؾ��Ѵ�
			return ResponseEntity.badRequest().build();
		}
		
		try {
			service.addPizza(pizza);
			
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		// ResponseEntity : ��Ȳ�� ���� ���ϴ� ������ ���� �� �ִ�. (���� �ڵ� Ȱ�� 100���� ���� 500���� ����)
		//ResponseEntity<Pizza> response = null;
		
		// RseponseEntity.ok() : Http �����ڵ� 200�� ������ �����. ����ȿ� ȭ���� ������ �ִ�
		//response = ResponseEntity.ok(null);
		
		// RseponseEntity.notFound() : Http �����ڵ� 404�� ������ �����.
		//response = ResponseEntity.notFound().build();
		
		// �����Ӱ� ���丸���
		//response = ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(service.getPizza(3));
		
		//return response;
		
		
	}


	
	@PutMapping(value="/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE) // row�� Integer1Integer�� �����ϱ� ������ text plain���� ���ó��ش�
	public String updatePizza(@RequestBody Pizza pizza) {
		//log.info("���� ����:" + pizza);
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
