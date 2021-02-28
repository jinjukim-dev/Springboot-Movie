<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>회원관리</title>
<div class="container">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">Member List📑</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입날짜</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="list" varStatus="st" items="${memberList}">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
				<td>${list.email}</td>
				<td>${list.regDate}</td>
				<td>
				<form:form  method="post"  action="memDelete" modelAttribute="MemberVO">
					<input type="hidden" name="id" value="${list.id}"/>
					<input type="submit" class="btn btn-danger" value="탈퇴"  id="delBtn" />
				</form:form>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<br /><br />
</div>