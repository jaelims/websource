/**
 * 영화진흥위원회 일일박스 오피스 오픈 api - json 데이터
 */
$(function(){
	init();
	
	$(":button").click(function(){
		let url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		url += $("#txtYear").val() + $("#selMon").val() + $("#selDay").val();
		
		console.log(url);
		
		$.getJSON({
			url:url,
			success:function(data){
				console.log(data);
				
				if($(data.boxOfficeResult.dailyBoxOfficeList) === ""){
					alert('데이터가 없습니다.');
				} else{
					let resData = "";

					$(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx,item){
						// 순위
						resData += item.rank+"위 ";
						
						// 증감
						if(item.rankInten > 0) resData += "(▲";
						else if(item.rankInten < 0) resData += "(▼";
						else resData += "(";
						resData += item.rankInten+") ";
						
					resData += "<a href='#' onclick='javascript:show("+item.movieCd+")'>"+item.movieNm + "</a><br>";
					})

					$("#msg").html(resData);
				}
			}
		})
	}) // $(":button") end
}) // $(function()) end
function show(movieCd){
	// 영화상세정보 요청
	let url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=";
	url += movieCd;
	
	console.log(url);
	
	$.getJSON({
		url:url,
		success:function(data){
			console.log(data);
			
			// 영화제목(한글)
			let movieNm = data.movieInfoResult.movieInfo.movieNm;
			// 영화제목(영어)
			let movieNmEn = data.movieInfoResult.movieInfo.movieNmEn;
			// 상영시간
			let showTm = data.movieInfoResult.movieInfo.showTm;
			// 감독명
			let directorNm = data.movieInfoResult.movieInfo.directors[0].peopleNm;
			// 출연배우명
			let peopleNm = "";
			// 출연 배우의 수
			let length = data.movieInfoResult.movieInfo.actors.length;
			$(data.movieInfoResult.movieInfo.actors).each(function(idx,item){ // idx : 0부터 시작하는 인덱스번호
				if(idx == length-1) {
					peopleNm += item.peopleNm;		
				} else {
					peopleNm += item.peopleNm + ", ";
				}
			})
			
			// 보여주기
			let resData = "<ul>";
			resData += "<li>영화제목(국문) : "+movieNm+"</li>";
			resData += "<li>영화제목(영문) : "+movieNmEn+"</li>";
			resData += "<li>상영시간 : "+showTm+"분</li>";
			resData += "<li>감독명 : "+directorNm+"</li>";
			resData += "<li>출연배우 : "+peopleNm+"</li></ul>";
			
			$(".box3").html(resData);
		}
	})
	
} // show() end
function init(){
	// 어제날짜 추출
	let newDate = new Date();
	let year = newDate.getFullYear(); // 연도
	let month = newDate.getMonth()+1; // 월 0부터 시작
	let day = newDate.getDate()-1; // 어제 날짜
	
	$("#txtYear").val(year);
	
	if(month < 10){
		month = "0"+month;
	}
	if(day < 10){
		day = "0"+day;
	}
	$("#selMon").val(month);
	$("#selDay").val(day);
} // init() end