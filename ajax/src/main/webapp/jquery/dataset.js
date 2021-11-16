/**
 * dataset.html - 서버에서 dataset.xml 데이터 요청 후 보여주기
 */
$(function(){
	$.get({
		url:"/data/dataset.xml",
		success:function(data){
			let output = "<table><tr><th>id</th><th>name</th><th>email</th><th>gender</th></tr>";
				
				$(data).find("record").each(function(){
					output += "<tr><td>"+$(this).find("id").text()+"</td>";
					output += "<td>"+$(this).find("name").text()+"</td>";
					output += "<td>"+$(this).find("email").text()+"</td>";
					output += "<td>"+$(this).find("gender").text()+"</td></tr>";
				})

				
				$("body").append(output);
		},
		error:function(xhr,textStatus,error){
			$("body").append("데이터 없음");
		}
	})
})
/*$(function(){
	$.ajax({
		url:"/data/dataset.xml",
		success:function(data){
			let output = "<ul>";
				
				$(data).find("record").each(function(){
					output += "<li>id : "+$(this).find("id").text()+"</li>";
					output += "<li>name : "+$(this).find("name").text()+"</li>";
					output += "<li>email : "+$(this).find("email").text()+"</li>";
					output += "<li>gender : "+$(this).find("gender").text()+"</li></br>";
				})
				output += "</ul>";
				
				$('#contents').html(output);
		},
		error:function(xhr,textStatus,error){
			$('#contents').html("데이터 없음");
		}
	})
})*/