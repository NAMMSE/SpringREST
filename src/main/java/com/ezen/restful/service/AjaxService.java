package com.ezen.restful.service;

import java.util.List;

import org.springframework.ui.Model;

import com.ezen.restful.dto.Pizza;

//0818 ����� Ǯ��
public interface AjaxService {
	public List<Pizza> getPizzaList(); // db���� ���ڸ� �����ͼ� ���������� �̸� ��Ͽ� ����ؾ��ϹǷ�
}
