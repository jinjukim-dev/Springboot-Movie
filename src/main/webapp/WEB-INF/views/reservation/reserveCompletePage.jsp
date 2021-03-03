<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>영화예매 완료창</title>
	<table>
		<tr class="sub">
			<th>${reserveInfo.id}님 예매가 완료되었습니다.</th>
		</tr>
		<tr>
			<td>
				<br>
				영화관 : ${reserveInfo.cinema_name } - ${reserveInfo.cinema_room }
				<br>
				영화 : ${reserveInfo.movie_sub }
				<br>
				<fmt:formatDate var="reserveDay" value="${reserveInfo.day }" pattern="yyyy-MM-dd(E)" />
				시간 : ${reserveDay } / ${reserveInfo.start_time } - ${reserveInfo.end_time }
				<br>
			</td>
		</tr>
	</table>