/**
 * getjson.html에서 메뉴4 클릭시 동작
 */

// 메뉴4와 이벤트 연결
let last_div = document.querySelector(".container div:last-child")
					   .addEventListener('click',makeRequest);

let xhr = new XMLHttpRequest();

function makeRequest(){
	xhr.onreadystatechange = getJson;
	xhr.open("get","/data/school.xml");
	xhr.send();
}

// 서버가 응답하는 경우 호출
function getJson(){
	// 서버가 보내준 데이터를 contents 영역에 보여주기
	let contents = document.querySelector("#contents");
	
	if(xhr.readyState == 4){
		if(xhr.status == 200) {
			// json 데이터를 자바스크립트 객체로 파싱
			let response = xhr.responseXML;
			console.log(response);
			
			/* xml 자체 형태로 그대로 보여줄 때
			let school = response.getElementsByTagName("school");
			contents.innerText = school[0].innerHTML;*/
			
			let title = response.getElementsByTagName("title");
			let time = response.getElementsByTagName("time");
			let teacher = response.getElementsByTagName("teacher");
			
			let data = "<ul><li>title : "+title[0].innerHTML+"</li>";
			data += "<li>time : "+time[0].innerHTML+"</li>";
			data += "<li>teacher : "+teacher[0].innerHTML+"</li></ul>";
			
			contents.innerHTML = data;
			
		} else {
			contents.innerHTML = "가져온 데이터 없음";
		}
	}
}
