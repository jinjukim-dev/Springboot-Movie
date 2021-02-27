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

#searchtxt {
	margin-left: 650px;
	margin-right: 0px;
}

#search {
	margin: 0px;
}
</style>
<script>
	function goRegist(code) {
		//location.href='...?code=' + code;
		document.t_regist.code.value = code;
		document.t_regist.submit();
	}
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



		<table border="1">
			<tr>
				<th>id</th>
				<th>성함</th>
				<th>영화 지점</th>
				<th>영화 관</th>
				<th>영화</th>
				<th>예약 일</th>
				<th>상영 시작 시간</th>
				<th>예약 좌석</th>

			</tr>
			<c:forEach items="${data}" var="dataVO">
				<tr>
					<td>${dataVO.id}</td>
					<td>${dataVO.name }</td>
					<td>${dataVO.cinema_name }</td>
					<td>${dataVO.cinema_room }</td>
					<td>${dataVO.movie_sub}</td>
					<td>${dataVO.schedule_date}</td>
					<td>${dataVO.start_time }</td>
					<td>${dataVO.seat_num }</td>

				</tr>

			</c:forEach>
		</table>

		<footer>
			<hr style="width: 80%;">
			<p>서울특별시 송파구 올리픽로 300 롯데월드 타워 27층 | 고객센터:1234-1234</p>
			<address>대표이메일:aman@sl.co.kr</address>
		</footer>

		<center>
</body>




</html>