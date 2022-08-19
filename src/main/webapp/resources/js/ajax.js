
const btn1 = document.getElementById('btn-xhttp');
const out = document.getElementById('out');
const btn2 = document.getElementById('btn-xhttp-put')


// 0818 강사님 문제풀이
// 피자 update

const select1 = document.getElementById('select-pizza-name')
const xhttp2 = new XMLHttpRequest();
const out2 = document.getElementById('out2')

const input_pizza_price = document.getElementById('input-pizza-price')
const input_pizza_calrories = document.getElementById('input-pizza-calrories')
const input_pizza_id = document.getElementById('input-pizza-id')
const input_pizza_name = document.getElementById('input-pizza-name')

xhttp2.addEventListener('readystatechange', (e) => { // 목록에서 피자이름 선택 시 요청 보낼 xhttp
	const readyState = e.target.readyState
	
	if(readyState == 4){ // 응답을 받아오면(4)
		const responseText = e.target.responseText; // 응답이 담겨있다(피자 정보 (sample/pizza/id))
		
        const pizza = JSON.parse(responseText);

        input_pizza_calrories.value = pizza.calrories;
        input_pizza_price.value = pizza.price;
        input_pizza_id.value = pizza.id;
        input_pizza_name.value = pizza.name;
	}
})

select1.addEventListener('change', (e) => { // 목록에서 피자이름을 선택했을때 일어나는 이벤트
    xhttp2.open('GET', '/restful/sample/pizza/' + e.target.value)
    xhttp2.send();
    
    //console.log('select tag event: ',e)
    console.log('selected option: ',e.target.value) // pizza의 아이디가 나온다 / jsp에서 해당 피자 옵션의 value를 피자아이디로 했기 때문

})

const xhttp3 = new XMLHttpRequest(); // 수정한 내용을 보낼 요청 

xhttp3.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;

    if(readyState == 4){
        const responseText = e.target.responseText;

        if(responseText == 1){
            out2.innerText= '성공적으로 수정되었습니다.'
            out2.style.color='green'
        }else{
            out2.innerText= responseText;
            out2.style.color='red'
        }
    }
})

btn2.addEventListener('click', (e) => {
    console.log('pizza id value: ', input_pizza_id.value)
    console.log('pizza name value: ', input_pizza_name.value)
    console.log('pizza price value: ', input_pizza_price.value)
    console.log('pizza calrories value: ', input_pizza_calrories.value)

    const pizza = {
        id: input_pizza_id.value,
        name: input_pizza_name.value,
        price: input_pizza_price.value,
        calrories: input_pizza_calrories.value

    };

    // GET방식은 주소 뒤에 ?name=value& ... 로 실어 보내면 되지만
    // 그 외 방식은 send(payload) 메서드에 데이터를 실어 보낸다
    xhttp3.open('PUT', '/restful/sample/pizza');

    // xhr request header 설정 (JSON 형식으로 보낸다고 서버에 알려야한다.)
    xhttp3.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    console.log('JSON string : ' , JSON.stringify(pizza));

    //xhttp.send(`{'name' : ${input_pizza_id.value}}`); 이런식으로 적어도 되지만
    // Object -> JSON(stringfy()) 이런 메서드가 있다
    xhttp3.send(JSON.stringify(pizza)); // 위에 선언한 pizza처럼 작성하면 문자열로 보내준다

})

/////////////////////////////////////////////////////////////////////////////////////////

// 피자 insert
const post_pizza_price = document.getElementById('post-pizza-price')
const post_pizza_name = document.getElementById('post-pizza-name')
const post_pizza_calrories = document.getElementById('post-pizza-calrories')
const btn4 = document.getElementById('btn-xhttp-post')
const out3 = document.getElementById('out3')

const xhttp4 = new XMLHttpRequest();



xhttp4.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;

    console.dir(e.target);

    if(readyState == 4){
        //const responseText = e.target.responseText;

        // e.target.status에 컨트롤러에서 만들어 보낸 http 상태 코드가 들어있다
        const httpStatus = e.target.Status; // 강사님 

        console.log('xhr4 http status', httpStatus);

        if(httpStatus == 200){
            //console.log('200 ok arrives');
            out3.style.color='green'
            out3.innerText='200 ok'
        }else if (httpStatus == 500){
            //console.log('500 internal server error arrived')
            out3.style.color='red'
            out3.innerText='500 internal server error!'
        }else if (httpStatus == 400) { // id 제외 하나라도 null 값일때
            //console.log('400 bad request arrived')
            out3.style.color='orange'
            out3.innerText='null value detected!'
        }



       // console.log(responseText)

        // if(responseText == 1){
        //     out3.innerText= '성공적으로 입력되었습니다.'
        //     out3.style.color='green'
        // }else{
        //     out3.innerText= responseText;
        //     out3.style.color='red'
        // }
    }
})

btn4.addEventListener('click', (e) => { // 업데이트 버튼

  

    const pizza = {
        name: post_pizza_name.value,
        price: post_pizza_price.value,
        calrories: post_pizza_calrories.value

    };


    

    console.log('JSON string : ' , JSON.stringify(pizza));
    console.log(pizza)

    xhttp4.open('POST', '/restful/sample/pizza')

    xhttp4.setRequestHeader('Content-type', 'application/json;charset=UTF-8');
    //xhttp.send(`{'name' : ${input_pizza_id.value}}`); 이런식으로 적어도 되지만
    // Object -> JSON(stringfy()) 이런 메서드가 있다
    
    xhttp4.send(JSON.stringify(pizza)); // 위에 선언한 pizza처럼 작성하면 문자열로 보내준다

})

///////////////////////////////////////////////////////////////////////////////////////////

//AJAX

// 1. AJAX를 위한 xhttp 인스턴스 생성
const xhttp = new XMLHttpRequest();


xhttp.addEventListener('readystatechange', (e) => {

    const pizza = JSON.parse(responseText);

})

// 2. xhttp에 이벤트 설정
xhttp.addEventListener('readystatechange', (e) => {
   // console.log('readystate event: ', e);
    
    const readyState = e.target.readyState; 
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('서버로 비동기 요청을 보냈다')
    }else if(readyState == 2){
        console.log('서버가 내 요청을 받았다')
    }else if(readyState == 3){
        console.log('서버가 내 요청에 대한 처리를 시작했다')
    }else if(readyState == 4){
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답이 도착했다')
        console.log('응답은 responseText에 들어있다', responseText)

        // 5. JSON 문자열 -> Javascript Object로 변환
        const pizza = JSON.parse(responseText);

        console.log('pizza name : ', pizza.name);
        console.log('pizza calrories : ', pizza.calrories);

        // 6. 받아온 데이터 활용
        const pizzaDiv = document.createElement('div');

        pizzaDiv.innerText = `${pizza.name}/${pizza.calrories}/${pizza.price}`;

        out.appendChild(pizzaDiv);
    }else{
        console.log('??? : ', readyState, ',' , responseText)
    }
});



btn1.addEventListener('click', (e) => {
    // 3. 새로운 xhttp 연결을 생성  / open(method, url)
    xhttp.open('GET', '/restful/sample/pizza/1');

    // 4. 원하는 타이밍에 요청을 전송
    xhttp.send();
})


