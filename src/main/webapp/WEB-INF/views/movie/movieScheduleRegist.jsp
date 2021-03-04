<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>영화 스케줄 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function changeSelet(cinema_code) {

		var target = document.getElementById("cinema");
		var cinema_code = target.options[target.selectedIndex].value;
		//alert('선택된 옵션 cinema_code : '+ cinema_code);

		$.ajax({
			type: "POST",
			url: "../getRoomInfo/"+cinema_code,
			data : {
				'cinema_code' : cinema_code
			},
			dataType: "json",
			contentType: "aplication/json; charset=UTF-8",
			success: function(data){
				if(data == null) {
					//$('#selectCinemaRoom').append("<option value= ' "+0+" '+>"+등록된 상영관이 없습니다.+"</option>");
				}
				
				console.log("success"+JSON.stringify(data));
				var keys = Object.keys(data);
				
				$("#selectCinemaRoom").empty(); //초기화
				for(var i in keys){						
					$('#selectCinemaRoom').append("<option value= ' "+keys[i]+" '+>"+data[keys[i]]+"</option>");
				}
				
			}
			
		});
	}
	
</script>

<style type="text/css">	
#movieScheduleRegist {
	margin: 0 auto;
	width: 600px;
}

#subBtn {
	margin: 0 auto;
	width: 100px;
}
</style>
<br/><br/>
<div class="container">
	<form:form method="post"  action="MoviescheduleRegist"  modelAttribute="MovieScheduleVO"  id="movieScheduleRegist" >
		<br />
		<h3 class="title-w3pvt mb-10"  id="title" style="font-size: 35px;" ><span style = "background-color:#FFFFE0">${movie_sub}</span> 상영관 스케줄 등록📅</h3>
		<br/><br/>
		<div class="form-group">
			<br />
			<input type="hidden" name="movie_code" value="${movie_code}">
			<form:select path="cinema_name" class="form-control"  id="cinema"  name="cinema"  onchange="changeSelet(this)">
			<form:option value="">지점을 선택해주세요.</form:option>
			<c:forEach var="list" varStatus="st" items="${cinemaList}">
				<form:option value="${list.cinema_code}">${list.cinema_name}</form:option>
			</c:forEach>
			</form:select>
			<br/>
			<form:select path="cinema_room" class="form-control"  id="selectCinemaRoom" name="selectCinemaRoom">
				<%-- <form:option value="상영관 선택"/> --%>
			</form:select>
			<br/>
			<form:input path="start_time" class="form-control"  placeholder="상영 시작 시간 ex) 12:00"/>
			<br/>
			<form:input path="end_time" class="form-control"  placeholder="상영 종료 시간 ex) 13:00"/>
			<br />
			<form:input path="schedule_date" class="form-control"  placeholder="상영 예정일 ex) 2021-01-01" />
			<br /><br />
			<input type="submit" class="btn btn-dark" value="스케줄 등록" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>