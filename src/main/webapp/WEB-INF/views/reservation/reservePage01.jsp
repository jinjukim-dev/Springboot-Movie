<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>영화 예매 페이지1</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	//클릭시 색변경
	$(document).ready(function() {
		$("li").each(function() {
			$(this).click(function() {
				$(this).addClass("selected"); //클릭된 부분을 상단에 정의된 CCS인 selected클래스로 적용
				$(this).siblings().removeClass("selected"); //siblings:형제요소들,    removeClass:선택된 클래스의 특성을 없앰
			});
		});
	});

	//클릭시 값 넘김
	//	$(document).on("click", '.movie', function movieInfo() {
	//		var movie = $(this).attr('value');
	//		//alert(movie);
	//		$('#movieName').text(movie);
	//		return movie;
	//	});

	//	$(document).on("click", '.cinema', function cinemaInfo() {
	//		var cinema = $(this).attr('value');
	//		//alert(cinema);
	//		$('#cinemaName').text(cinema);
	//		$('#cinemaName').val(cinema);
	//		return cinema;
	//	});

	//	$(document).on("click", '.day', function dayInfo() {
	//		var day = $(this).attr('value');
	//		//alert(cinema);
	//		$('#day').text(day);
	//		$('#day').val(day);
	//		return day;
	//	});

	////////////
</script>
<style type="text/css">
table {
	margin: auto;
}

.sub {
	text-align: center
}

ul, li {
	list-style: none;
}

a {
	margin: 5px;
	padding: 2px;
	display: block; /* 클릭범위전체 */
}

.selected {
	background-color: #b5e5ff;
}
</style>
	<table border="1" cellpadding="10">
		<tr class="sub">
			<th>영화</th>
			<th>극장</th>
			<th>날짜</th>
			<th></th>
		</tr>
		<form:form action="./reservePage01" method="post">
			<tr>
				<td>
					<ul>
						<c:forEach items="${movieList }" var="movieVO">
							<!-- ${movieVO.movie_code} -->
							<li><input type="radio" name="movie" class="movie" value='${movieVO.movie_code}'> ${movieVO.movie_sub } - ${movieVO.movie_age }</input></li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach items="${cinemaList }" var="cinemaVO">
							<li><input type="radio" name="cinema" class="cinema" value='${cinemaVO.cinema_code}'> ${cinemaVO.cinema_location } -
								${cinemaVO.cinema_name }</input></li>
						</c:forEach>
					</ul>
				</td>
				<td>
					<ul>
						<c:forEach items="${schedule_dateList }" var="scheduleVO">
							<fmt:formatDate var="day" value="${scheduleVO.schedule_date}" pattern="yyyy-MM-dd(E)" />
							<li><input type="radio" name="day" class="day" value='${day }'>${day }</input></li>
						</c:forEach>
					</ul>
				</td>
				<td id="time"><input type="submit" value="시간표 보기"> <br></td>
			</tr>
			<tr>
				<th colspan="2">영화 정보</th>
				<th colspan="1">시간</th>
				<th></th>
			</tr>
		</form:form>
		<form:form action="./reservePage02" method="get">
			<tr>
				<td id="reservationInfo" colspan="2"><label>영화 : ${reserveInfo.movie_sub }</label><br> <label>극장 : ${reserveInfo.cinema_name}</label><br>

					<fmt:formatDate var="reserveDay" value="${reserveInfo.day }" pattern="yyyy-MM-dd(E)" /> <label>날짜 : ${reserveDay}</label></td>
				<td colspan="1">
					<ul>
						<c:forEach items="${timeList }" var="scheduleVO">
							<li><input type="radio" name="strTime" class="strTime" value='${scheduleVO.schedule_code }'>${scheduleVO.cinema_room} -
								${scheduleVO.start_time } - 총 ${scheduleVO.seat_qnt }석</input></li>
						</c:forEach>
					</ul> <!-- 영화정보 --> <input type="hidden" name="movie_code" value="${reserveInfo.movie_code}" /> <input type="hidden" name="movie_sub"
					value="${reserveInfo.movie_sub}" /> <input type="hidden" name="cinema_code" value="${reserveInfo.cinema_code}" /> <input type="hidden"
					name="cinema_name" value="${reserveInfo.cinema_name}" /> <input type="hidden" name="strDay" value="${reserveDay }" /> <input type="hidden"
					name="id" value="${authInfo.id }" />
				</td>
				<td><input type="submit" value="예매하기"></td>
			</tr>
		</form:form>
	</table>