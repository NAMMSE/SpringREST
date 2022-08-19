<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>AJAX 사용하기</title>
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
	
	<p>정적 자원들은 webapp/resources/에 보관하고 /resource/** uri로 접근하면 된다
		(servlet-context의 내용을 참조)
		http://localhost:8888/restful/resources/images/penguin.jpg 이런식
	</p>
	<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg" alt="" />
	<img src="/restful/resources/images/penguin.jpg" alt="" />
	
	

	<button id="btn-xhttp">xhttp 요청 보내기</button> <br>

	<!-- select 태그에서 무언가를 선택했을때 발생하는 이벤트가 있다.-->
	name : 
	<select id="select-pizza-name" name="name">
		<option id="value" value="null">db에서 가져온 피자이름들을 넣기</option>
		<c:forEach items="${pizzas }" var="pizza">
			<option value="${pizza.id }">${pizza.name }</option>
		</c:forEach>
	</select> <br>
		
	price : <input id="input-pizza-price" type="text" placeholder="피자를 선택하면 값이 채워집니다." /> <br>
	calrories : <input id="input-pizza-calrories" type="text" placeholder="피자를 선택하면 값이 채워집니다" /> <br>
	pizza id : <input id="input-pizza-id" type="text" placeholder="피자를 선택하면 값이 채워집니다." readonly />
	<input id="input-pizza-name" type="hidden" />
	
	<button id="btn-xhttp-put">xhttp PUT 해보기 (Update)</button>

	<hr>

	<div id="out2"> 아직 수정 전입니다. </div>

	<hr />
	
	price : <input id="post-pizza-price" type="text"  /> <br>
	calrories : <input id="post-pizza-calrories" type="text"  /> <br>
	name : <input id="post-pizza-name" type="text" />
	<button id="btn-xhttp-post">XHTTP POST 해보기</button>
	
	<hr />
	
	<div id="out3"> 아직 추가 전입니다. </div>
	
	<hr />

	<div id="out"></div>
	
	<script src="/restful/resources/js/ajax.js"></script>
	
</body>
</html>