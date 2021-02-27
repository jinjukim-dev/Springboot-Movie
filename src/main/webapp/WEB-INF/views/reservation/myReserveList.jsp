<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>예매 확인</title>

<div class="container">
	<br /><br />
	<h3>${authInfo.name}님의  예매 내역</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>지점명</th>
				<th>관</th>
				<th>영화</th>
				<th>상영시작시간</th>
				<th>예매 날짜</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="list" varStatus="st" items="${reserveList}">
			<tr>
				<td>${list.cinema_name}</td>
				<td>${list.cinema_room}</td>
				<td>${list.movie_sub}</td>
				<td>${list.start_time}</td>
				<td>${list.schedule_date}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br /><br />
</div>
