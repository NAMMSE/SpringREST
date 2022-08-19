<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AJAX ����ϱ�</title>
<style>
	img{
		width: 100px;
	}

</style>
</head>
<!-- 0817 -->
<body>

	<h3>AJAX Index</h3>
	
	<h5>static resource mapping</h5>
	
	<p>���� �ڿ����� webapp/resources/�� �����ϰ� /resource/** uri�� �����ϸ� �ȴ�
		(servlet-context�� ������ ����)
		http://localhost:8888/restful/resources/images/penguin.jpg �̷���
	</p>
	<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg" alt="" />
	<img src="/restful/resources/images/penguin.jpg" alt="" />
	
	

	<button id="btn-xhttp">xhttp ��û ������</button> <br>

	<!-- select �±׿��� ���𰡸� ���������� �߻��ϴ� �̺�Ʈ�� �ִ�.-->
	name : 
	<select id="select-pizza-name" name="name">
		<option id="value" value="null">db���� ������ �����̸����� �ֱ�</option>
		<c:forEach items="${pizzas }" var="pizza">
			<option value="${pizza.id }">${pizza.name }</option>
		</c:forEach>
	</select> <br>
		
	price : <input id="input-pizza-price" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�." /> <br>
	calrories : <input id="input-pizza-calrories" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" /> <br>
	pizza id : <input id="input-pizza-id" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�." readonly />
	<input id="input-pizza-name" type="hidden" />
	
	<button id="btn-xhttp-put">xhttp PUT �غ��� (Update)</button>

	<hr>

	<div id="out2"> ���� ���� ���Դϴ�. </div>

	<hr />
	
	price : <input id="post-pizza-price" type="text"  /> <br>
	calrories : <input id="post-pizza-calrories" type="text"  /> <br>
	name : <input id="post-pizza-name" type="text" />
	<button id="btn-xhttp-post">XHTTP POST �غ���</button>
	
	<hr />
	
	<div id="out3"> ���� �߰� ���Դϴ�. </div>
	
	<hr />

	<div id="out"></div>
	
	<script src="/restful/resources/js/ajax.js"></script>
	
</body>
</html>