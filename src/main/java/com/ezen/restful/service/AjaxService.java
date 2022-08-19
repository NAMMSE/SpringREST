package com.ezen.restful.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ezen.restful.dto.Pizza;

//0818 강사님 풀이
public interface AjaxService {
	public List<Pizza> getPizzaList(); // db에서 피자를 가져와서 페이지에서 이름 목록에 출력해야하므로
}
