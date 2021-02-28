<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>예매관리</title>

<div class="container">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">예매 리스트📅</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>회원 ID</th>
				<th>성함</th>
				<th>영화 지점</th>
				<th>영화관</th>
				<th>영화</th>
				<th>예매 날짜</th>
				<th>상영 시작 시간</th>
				<th>예매 좌석</th>
			</tr>
		</thead>
		<tbody>
		<form>
		<c:forEach var="list" varStatus="st" items="${data}">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.cinema_name}</td>
				<td>${list.cinema_room}</td>
				<td>${list.movie_sub}</td>
				<td>${list.schedule_date}</td>
				<td>${list.start_time}</td>
				<td>${list.seat_num}</td>
			</tr>
		</c:forEach>
		</form>
		</tbody>
	</table>
	<br /><br />
</div>