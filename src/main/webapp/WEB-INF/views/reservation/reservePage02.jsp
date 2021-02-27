<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
	margin: auto;
}

.sub {
	text-align: center;
}
</style>
<title>영화 예매02</title>

<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/heml; charset=UTF-8" />
<meta name="keywords"
	content="CGBOX Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}

	//좌석 체크박스
	$(document).ready(function() {
		$(":checkbox").change(function() {
			var cnt = $("#cnt").val();
			btn = document.getElementById('reserveBtn');
			
			//갯수가 같을 때
			if (cnt == $(":checkbox:checked").length) {
				$(":checkbox:not(:checked)").attr("disabled", "disabled");
				//alert();
			} else { //다를 때
				$(":checkbox").removeAttr("disabled");
				btn.disabled = 'disabled'
			}

			$("#cnt").change(function() {
				$(":checkbox").removeAttr("checked");
				$(":checkbox").removeAttr("disabled");
				btn.disabled = 'disabled'
			});
		});
	});
	
	//좌석 중복체크
	$(function() {
		$('#seatDup').click(function() {
			var seatChecked = new Array();
			var schedule_code = $("input[name='schedule_code']").val();
			$("input[name='seat']:checked").each(function(i) {
				//seatChecked[i].push($(this).val());
				seatChecked[i] = $(this).val();
			});			
			
			//alert(JSON.stringify(seatChecked));
			$.ajax({
				url : '../reservePage02',
				method : 'GET',
				data : {
					'seatArr' : seatChecked.join(','),
					'schedule_code' : schedule_code
				},

				dataType : 'json',
				success : function(data) {
					var result = data.code;
					var cnt = $("#cnt").val();
					btn = document.getElementById('reserveBtn');
					if(result == "dup"){
						alert('자리 중복');
						btn.disabled = 'disabled'
					}else{
						alert('가능 자리');
						btn = document.getElementById('reserveBtn');
						btn.disabled = false;
						document.getElementById("cntPrint").innerHTML = '10000원 X ' + cnt + ' = ' + (cnt * 10000) + '원';
					}
				}
			});
			
		});
	});
	
</script>
<!-- //Meta tag Keywords -->
<!-- Custom-Files -->
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="../css/style.css" type="text/css"
	media="all" />
</head>
<body>
	<table class="sub" border="1" cellpadding="10">

		<tr>
			<th>영화 정보</th>
			<th>좌석 선택</th>
			<th>좌석수</th>
			<th></th>
		</tr>
		<form:form action="./reservePage02" method="post">
			<tr>
				<td align="left" rowspan="1">
					<label>영화 : ${reserveInfo.movie_sub }</label>
					<br>
					<label>극장 : ${reserveInfo.cinema_name}</label>
					<br>
					<fmt:formatDate var="reserveDay" value="${reserveInfo.day }" pattern="yyyy-MM-dd(E)" />
					<label>일시 : ${reserveDay} - ${reserveInfo.start_time}</label>
					<br>
					<label>좌석 수 : 총 ${reserveInfo.totalSeat }석 / ${reserveInfo.extraSeat }석</label>
					<input type="hidden" name="movie_code" value="${reserveInfo.movie_code}" />
					<input type="hidden" name="movie_sub" value="${reserveInfo.movie_sub}" />
					<input type="hidden" name="cinema_code" value="${reserveInfo.cinema_code}" />
					<input type="hidden" name="cinema_name" value="${reserveInfo.cinema_name}" />
					<input type="hidden" name="cinema_room" value="${reserveInfo.cinema_room}" />
					<input type="hidden" name="schedule_code" value="${reserveInfo.schedule_code}" />
					<input type="hidden" name="strDay" value="${reserveDay}" />
					<input type="hidden" name="strStart_time" value="${reserveInfo.start_time}" />
					<input type="hidden" name="strEnd_time" value="${reserveInfo.end_time}" />
					<input type="hidden" name="totalSeat" value="${reserveInfo.totalSeat}" />
					<input type="hidden" name="extraSeat" value="${reserveInfo.extraSeat}" />
					<input type="hidden" name="id" value="${reserveInfo.id}" />
				</td>
				<td rowspan="1"><select id="cnt" name='cnt'>
						<option value="1">1명</option>
						<option value="2">2명</option>
						<option value="3">3명</option>
						<option value="4">4명</option>
						<option value="5">5명</option>
						<option value="6">6명</option>
						<option value="7">7명</option>
						<option value="8">8명</option>
				</select></td>

				<td rowspan="1"><label>Screen</label><br> <c:forEach
						begin="10" end="80" step="10" var="x">
						<c:forEach begin="0" end="4" var="y">
							${x+y-9<10?"0":""}${x+y-9}<input type="checkbox" value="${x+y-9}" name="seat">
						</c:forEach>
						&emsp;
						<c:forEach begin="5" end="9" var="z">
							${x+z-9<10?"0":""}${x+z-9}<input type="checkbox" value="${x+z-9}" name="seat">
						</c:forEach>
						<br>
					</c:forEach></td>
				<td rowspan="1">
					<input type="button" id="seatDup" value="좌석 확인">
					<br>
					<br>
					<input type="submit" id="reserveBtn" value="예매하기" disabled="">
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<p id="cntPrint"></p>
				</td>
			</tr>
		</form:form>
	</table>
</body>
</html>