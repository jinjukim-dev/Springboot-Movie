<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>해당 영화 상영관 정보</title>

<div class="container">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">Movie Schedule List🎬</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>지점</th>
				<th>상영관</th>
				<th>시작 시간</th>
				<th>끝나는 시간</th>
				<th>좌석 수</th>
				<th>상영일</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<form>
		<c:forEach var="list" varStatus="st" items="${scheduleList}">
			<tr>
				<td>${list.cinema_name}</td>
				<td>${list.cinema_room }</td>
				<td>${list.start_time}</td>
				<td>${list.end_time }</td>
				<td>${list.seat_num }</td>
				<td>${list.schedule_date}</td>
				<td>
				<form:form method="post" action="" modelAttribute="">
					<input type="hidden" name="" value=""/>
					<input type="submit" class="btn btn-danger" value="삭제"  id="subBtn" />
				</form:form>
				</td>			
			</tr>
		</c:forEach>
		</form>
		</tbody>
	</table>
	<br /><br />
</div>