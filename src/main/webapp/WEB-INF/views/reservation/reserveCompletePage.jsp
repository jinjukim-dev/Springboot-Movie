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
<title>영화 예매 완료</title>

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
</script>
<!-- //Meta tag Keywords -->
<!-- Custom-Files -->
<link rel="stylesheet" href="../css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="../css/style.css" type="text/css" media="all" />
</head>
<body>
<br>
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
</body>
</html>