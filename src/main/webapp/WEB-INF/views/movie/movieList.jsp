<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>회원관리</title>

<div class="container">
	<br /><br />
	<h3 style="font-size: 35px; font-weight: bold;">Movie List🎬</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>영화 제목</th>
				<th>감독</th>
				<th>영화 장르</th>
				<th>개봉일</th>
				<th>관람연령</th>
				<th>상영시간</th>
				<th>스케줄 관리</th>
				<th>스케쥴 등록</th>
				<th>영화 삭제</th>
			</tr>
		</thead>
		<tbody>
		<form>
		<c:forEach var="list" varStatus="st" items="${movieList}">
			<tr>
				<td>${list.movie_sub}</td>
				<td>${list.movie_direc}</td>
				<td>${list.movie_gen}</td>
				<td>${list.movie_open}</td>
				<td>${list.movie_age}</td>
				<td>${list.movie_time}</td>
				<td>
				<form:form method="post" action="scheduleList" modelAttribute="MovieVO">
					<input type="hidden" name="movie_code"  value="${list.movie_code}">
					<input type="submit" class="btn btn-secondary" value="스케줄 목록 " id="subBtn" />
				</form:form>
				</td>
				<td>
				<form:form method="post" action="scheduleRegist" modelAttribute="MovieVO">
					<input type="hidden" name="movie_code"  value="${list.movie_code}">
					<input type="submit" class="btn btn-primary" value="스케줄 등록"  id="subBtn" />
				</form:form>
				</td>
				<td>
				<form:form method="post" action="deleteMovie" modelAttribute="MovieVO">
					<input type="hidden" name="movie_code" value="${list.movie_code}"/>
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