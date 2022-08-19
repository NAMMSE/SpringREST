
const btn1 = document.getElementById('btn-xhttp');
const out = document.getElementById('out');
const btn2 = document.getElementById('btn-xhttp-put')


// 0818 ����� ����Ǯ��
// ���� update

const select1 = document.getElementById('select-pizza-name')
const xhttp2 = new XMLHttpRequest();
const out2 = document.getElementById('out2')

const input_pizza_price = document.getElementById('input-pizza-price')
const input_pizza_calrories = document.getElementById('input-pizza-calrories')
const input_pizza_id = document.getElementById('input-pizza-id')
const input_pizza_name = document.getElementById('input-pizza-name')

xhttp2.addEventListener('readystatechange', (e) => { // ��Ͽ��� �����̸� ���� �� ��û ���� xhttp
	const readyState = e.target.readyState
	
	if(readyState == 4){ // ������ �޾ƿ���(4)
		const responseText = e.target.responseText; // ������ ����ִ�(���� ���� (sample/pizza/id))
		
        const pizza = JSON.parse(responseText);

        input_pizza_calrories.value = pizza.calrories;
        input_pizza_price.value = pizza.price;
        input_pizza_id.value = pizza.id;
        input_pizza_name.value = pizza.name;
	}
})

select1.addEventListener('change', (e) => { // ��Ͽ��� �����̸��� ���������� �Ͼ�� �̺�Ʈ
    xhttp2.open('GET', '/restful/sample/pizza/' + e.target.value)
    xhttp2.send();
    
    //console.log('select tag event: ',e)
    console.log('selected option: ',e.target.value) // pizza�� ���̵� ���´� / jsp���� �ش� ���� �ɼ��� value�� ���ھ��̵�� �߱� ����

})

const xhttp3 = new XMLHttpRequest(); // ������ ������ ���� ��û 

xhttp3.addEventListener('readystatechange', (e) => {

    const readyState = e.target.readyState;

    if(readyState == 4){
        const responseText = e.target.responseText;

        if(responseText == 1){
            out2.innerText= '���������� �����Ǿ����ϴ�.'
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

    // GET����� �ּ� �ڿ� ?name=value& ... �� �Ǿ� ������ ������
    // �� �� ����� send(payload) �޼��忡 �����͸� �Ǿ� ������
    xhttp3.open('PUT', '/restful/sample/pizza');

    // xhr request header ���� (JSON �������� �����ٰ� ������ �˷����Ѵ�.)
    xhttp3.setRequestHeader('Content-type', 'application/json;charset=UTF-8');

    console.log('JSON string : ' , JSON.stringify(pizza));

    //xhttp.send(`{'name' : ${input_pizza_id.value}}`); �̷������� ��� ������
    // Object -> JSON(stringfy()) �̷� �޼��尡 �ִ�
    xhttp3.send(JSON.stringify(pizza)); // ���� ������ pizzaó�� �ۼ��ϸ� ���ڿ��� �����ش�

})

/////////////////////////////////////////////////////////////////////////////////////////

// ���� insert
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

        // e.target.status�� ��Ʈ�ѷ����� ����� ���� http ���� �ڵ尡 ����ִ�
        const httpStatus = e.target.Status; // ����� 

        console.log('xhr4 http status', httpStatus);

        if(httpStatus == 200){
            //console.log('200 ok arrives');
            out3.style.color='green'
            out3.innerText='200 ok'
        }else if (httpStatus == 500){
            //console.log('500 internal server error arrived')
            out3.style.color='red'
            out3.innerText='500 internal server error!'
        }else if (httpStatus == 400) { // id ���� �ϳ��� null ���϶�
            //console.log('400 bad request arrived')
            out3.style.color='orange'
            out3.innerText='null value detected!'
        }



       // console.log(responseText)

        // if(responseText == 1){
        //     out3.innerText= '���������� �ԷµǾ����ϴ�.'
        //     out3.style.color='green'
        // }else{
        //     out3.innerText= responseText;
        //     out3.style.color='red'
        // }
    }
})

btn4.addEventListener('click', (e) => { // ������Ʈ ��ư

  

    const pizza = {
        name: post_pizza_name.value,
        price: post_pizza_price.value,
        calrories: post_pizza_calrories.value

    };


    

    console.log('JSON string : ' , JSON.stringify(pizza));
    console.log(pizza)

    xhttp4.open('POST', '/restful/sample/pizza')

    xhttp4.setRequestHeader('Content-type', 'application/json;charset=UTF-8');
    //xhttp.send(`{'name' : ${input_pizza_id.value}}`); �̷������� ��� ������
    // Object -> JSON(stringfy()) �̷� �޼��尡 �ִ�
    
    xhttp4.send(JSON.stringify(pizza)); // ���� ������ pizzaó�� �ۼ��ϸ� ���ڿ��� �����ش�

})

///////////////////////////////////////////////////////////////////////////////////////////

//AJAX

// 1. AJAX�� ���� xhttp �ν��Ͻ� ����
const xhttp = new XMLHttpRequest();


xhttp.addEventListener('readystatechange', (e) => {

    const pizza = JSON.parse(responseText);

})

// 2. xhttp�� �̺�Ʈ ����
xhttp.addEventListener('readystatechange', (e) => {
   // console.log('readystate event: ', e);
    
    const readyState = e.target.readyState; 
    const responseText = e.target.responseText;

    if(readyState == 1){
        console.log('������ �񵿱� ��û�� ���´�')
    }else if(readyState == 2){
        console.log('������ �� ��û�� �޾Ҵ�')
    }else if(readyState == 3){
        console.log('������ �� ��û�� ���� ó���� �����ߴ�')
    }else if(readyState == 4){
        console.log('������ ó���� ������ �� ��û�� ���� ������ �����ߴ�')
        console.log('������ responseText�� ����ִ�', responseText)

        // 5. JSON ���ڿ� -> Javascript Object�� ��ȯ
        const pizza = JSON.parse(responseText);

        console.log('pizza name : ', pizza.name);
        console.log('pizza calrories : ', pizza.calrories);

        // 6. �޾ƿ� ������ Ȱ��
        const pizzaDiv = document.createElement('div');

        pizzaDiv.innerText = `${pizza.name}/${pizza.calrories}/${pizza.price}`;

        out.appendChild(pizzaDiv);
    }else{
        console.log('??? : ', readyState, ',' , responseText)
    }
});



btn1.addEventListener('click', (e) => {
    // 3. ���ο� xhttp ������ ����  / open(method, url)
    xhttp.open('GET', '/restful/sample/pizza/1');

    // 4. ���ϴ� Ÿ�ֿ̹� ��û�� ����
    xhttp.send();
})


