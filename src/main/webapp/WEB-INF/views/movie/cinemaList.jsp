<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>회원관리</title>

<div class="container">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">상영관 관리</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>지역</th>
				<th>지점명</th>
				<th>지점 주소</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<form>
		<c:forEach var="list" varStatus="st" items="${cinemaList}">
			<tr>
				<td>${list.cinema_location}</td>
				<td>${list.cinema_name}</td>
				<td>${list.cinema_info}</td>
				<td><input type="submit" class="btn btn-primary" value="상영관 등록"  id="subBtn" /></td>
				<td><input type="submit" class="btn btn-dark" value="상영관 리스트 " id="subBtn" /></td>
				<td><input type="submit" class="btn btn-danger" value="지점삭제"  id="subBtn" /></td>			
			</tr>
		</c:forEach>
		</form>
		</tbody>
	</table>
	<br /><br />
</div>