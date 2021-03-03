<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>상영관 리스트</title>

<style type="text/css">
#cinemaroomList {
	margin: 0 auto;
	width: 600px;
}

#subBtn {
	margin: 0 auto;
	width: 100px;
}
</style>

<div class="container"  id = "cinemaroomList">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">상영관 리스트 </h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>관 이름</th>
				<th>좌석</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<form>
		<c:forEach var="list" varStatus="st" items="${roomList}">
			<tr>
				<td>${list.cinema_room}</td>
				<td>${list.seat_qnt}</td>
				<td>
				<form:form method="post" action="cinemaInfoRoomDelete" modelAttribute="cinemaRoomVO">
					<input type="hidden" name="cinemaroom_code" value="${list.cinemaroom_code}"/>
					<input type="submit" class="btn btn-danger" value="상영관 삭제"  id="subBtn" />
				</form:form>
				</td>		
			</tr>
		</c:forEach>
		</form>
		</tbody>
	</table>
	<br /><br />
</div>