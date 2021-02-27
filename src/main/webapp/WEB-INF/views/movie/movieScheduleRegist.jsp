<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 20px;
	padding: 0px;
}

.join {
	text-align: center;
}

a:link {
	text-decoration: none;
	color: black;
}

h1 {
	margin: 8px;
}

header {
	text-align: center;
	height: 60px;
}

form fieldset {
	margin-bottom: 25px;
	width: 800px;
}

form legend {
	font-size: 16px;
	font-weight: 550;
}

form label.reg {

	font-size: 16px;
	width: 110px;
	color: black;
	font-weight: bold;
	float: left;
	text-align: right;
	margin-right: 5px;
	 margin-left: 100px;
}

body {
	background-color: #fff8dc;
}

#register {
	background-color: #fffaf0;
}

form ul li {
	list-style: none;
	margin: 10px 0;
	font-size: 14px;
}

#test_btn1 {
	border-radius: 5px;
	margin-right: -4px;
	height: 30px;
	width: 110px;
	background-color: #b0e0e6;
}

#idChek {
	border-radius: 5px;
	margin-right: -4px;
	height: 23px;
	width: 70px;
	background-color: lightgray;
}

input {
	margin-right: 150px;
}

footer {
	font-size: 8px;
	margin-top: 140px;
}

#poster {
	margin-right: 80px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function() {
		var cinema_seatArr = new Array();
		$('#cinema_code').change(
				function() {
					var code = $('#cinema_code').val();
					$.ajax({
						url : '../getRoomInfo',
						method : 'POST',
						data : {
							'cinema_code' : code
						},
						dataType : 'json',
						success : function(data) {
							console.log(data);
							$('#cinema_room').empty();

							cinema_seatArr.length = 0;
							for (var i = 0; i < data.length; i++) {
								console.log(data[i].cinema_seat);
								//$('#cinema').prepend('<option >' + data[i].cinema_room+ '</option>') ;
								var option = $('<option value='+data[i].cinema_room+'>' + data[i].cinema_room
										+ '</option>');
								$('#cinema_room').append(option);
							/* 	$('#cinema_seat').html(data[i].cinema_seat); */
								cinema_seatArr[i] = data[i].cinema_seat;
								
							}
							
				

						}
					})
				})
				
				$('#cinema_room').change(function(){
					//var text=$("#cinema_room").val();
					//$('#cinema_seat').val(text);
					var idx = $("#cinema_room option").index($("#cinema_room option:selected"));
					$('#cinema_seat').val(cinema_seatArr[idx]);
				});
				
	});
	
	

	
	
</script>
</head>
<body>

	<header>
		<h1>
		<a href="http://localhost:8080/springteam04/admin">CGBOX</a>
		</h1>
		<br>
	</header>
	<center>
		<form:form action="scheduleRegist" method="post"
			modelAttribute="scheduleVO" name="scheduleFrm">
			<input type="hidden" value="${movieList.movie_code}" name="code">
			<fieldset id="register">

				<legend>영화관 상영 스케쥴 등록</legend>
				<ul>
					<li><label class="reg" for="title">영화 명 :</label> <input
						type="text" readonly value="${movieList.movie_sub}" />
						<input type="hidden" value="${movieList.movie_code}" name="movie_code"></li>
							<li><label class="reg" for="start_time">영화 상영 시간</label><input
						type="text" readonly value="${movieList.movie_time}" /></li>
					<li><label class="reg" for="localType">상영 극장 :</label> <select
						id="cinema_code" name="cinema_code">
							<option value="0">극장을 선택해 주세요</option>
							<c:forEach items="${cinemaList}" var="cinemaList">
								<option value="${cinemaList.cinema_code}">${cinemaList.cinema_name}</option>

							</c:forEach>
					</select></li>
					<li><label class="reg" for="cinemaRoom">상영 관 :</label> <select
						id="cinema_room" name="cinema_room">
							<option>--선택--</option>
					</select></li>
				
					<li><label class="reg" for="start_time">영화 시작 시간 :</label>
					<form:input path="start_time" /><form:errors path="start_time"/></li>
					
					<li><label class="reg" for="end_time">영화 종료 시간 :</label><form:input path="end_time"/><form:errors path="end_time"/></li>
					<li><label class="reg" for="schedule_date">상영 예정 일:</label><form:input path="schedule_date"/><form:errors path="schedule_date"/></li>
					<li><label class="reg" for="seat_qnt">총 좌석 :</label> <input type="text" id="cinema_seat" name="seat_qnt"/></li>
					
					<%-- 
				    <li><label class="reg" for="localType">지역:</label> 
				    
				    <input type="text" readonly value="${cinemaVO.cinema_info}" /></li>
					
					<li><label class="reg" for="title">지점 명 :</label><input type="text"> </li>
					<li><label class="reg" for="day">상영 일 :</label> <form:input path="schedule_date"/></li>
					<li><label class="reg" for="start_time">영화 시작 시간 :</label><form:input path="start_time"/></li>
					<li><label class="reg" for="end_time">영화 종료 시간 :</label><form:input path="end_time"/></li>
					<li><label class="reg" for="title">총 좌석 :</label> <input type="text" readonly value="${cinemacodeinfo.cinema_seat}" name="cinema_seat"/></li>
					 --%>
				</ul>
				<br>
			</fieldset>
			<fieldset style="text-align: center; border: none;">
				<button id="test_btn1" type="submit" value="submit">등록하기</button>
			</fieldset>
		</form:form>

		<footer>
			<hr style="width: 80%;">
			<p>서울특별시 송파구 올리픽로 300 롯데월드 타워 27층 | 고객센터:1234-1234</p>
			<address>대표이메일:aman@sl.co.kr</address>
		</footer>
		<center>
</body>




</html>