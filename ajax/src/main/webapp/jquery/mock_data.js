/**
 * mock_data.json 파일 요청 후 보여주기
 */
$(function(){
	$.getJSON({
		url:"/data/MOCK_DATA.json",
		success:function(data){
			let output = "<table><tr><th>id</th><th>name</th><th>email</th><th>gender</th><th>ip_address</th></tr>";
				
				$(data).each(function(idx,item){			
					output += "<tr><td>"+item.id+"</td>";
					output += "<td>"+item.name+"</td>";
					output += "<td>"+item.email+"</td>";
					output += "<td>"+item.gender+"</td>";
					output += "<td>"+item.ip_address+"</td></tr>";
				})
				
				$("#contents").html(output);
		},
		error:function(xhr,textStatus,error){
			$("body").append("데이터 없음");
		}
	})
})
/*$(function(){
	$.getJSON({
		url:"/data/MOCK_DATA.json",
		success:function(data){
			let output = "<ul>";
				$(data).each(function(idx,item){			
					output += "<li>id : "+item.id+"</li>";
					output += "<li>name : "+item.name+"</li>";
					output += "<li>email : "+item.email+"</li>";
					output += "<li>gender : "+item.gender+"</li>";
					output += "<li>ip_address : "+item.ip_address+"</li></br>";
				})
				output += "</ul>";
				
				$("#contents").html(output);
		},
		error:function(xhr,textStatus,error){
			$('#contents').html("데이터 없음");
		}
	})
})*/