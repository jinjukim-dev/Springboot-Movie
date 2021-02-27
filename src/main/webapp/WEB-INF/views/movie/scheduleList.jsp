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
	margin-left: 210px;
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

				<th>영화관 코드</th>
				<th>관</th>
				<th>시작 시간</th>
				<th>끝나는 시간</th>
				<th>총 좌석 수</th>
				<th>상영 일</th>
				<th>삭제</th>
			</tr>

			<c:forEach items="${scheduleList}" var="scheduleVO">
				<tr>
					<td>${scheduleVO.cinema_code}</td>
					<td>${scheduleVO.cinema_room }</td>
					<td>${scheduleVO.start_time }</td>
					<td>${scheduleVO.end_time }</td>
					<td>${scheduleVO.seat_qnt }</td>
					<td>${scheduleVO.schedule_date }</td>


					<td><form:form action="../schedule/deleteSchedule"
							method="post" modelAttribute="scheduleVO">
							<input type="hidden" name="code"
								value="${scheduleVO.schedule_code}">
							<input type="hidden" name="moviecode"
								value="${scheduleVO.movie_code}">

							<input type="submit" value="삭제">
						</form:form></td>
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