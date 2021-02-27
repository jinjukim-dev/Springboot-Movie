<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MovieBOX | 영화사이트</title>
<meta name="keywords" content="MovieBOX" />
<meta http-equiv="Content-Type" content="text/heml; charset=UTF-8" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<style type="text/css">
	#div {
		margin: 0 auto;
	}
</style>
<link rel="stylesheet" href="http://localhost:8080/springteam04/css/bootstrap.css">
<link rel="stylesheet" href="http://localhost:8080/springteam04/css/style.css" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="main-w3layouts-header-sec">
		<!-- header -->
		<header class="header-w3ls">
			<div class="container-fluid inner-sec-w3ls">
				<div class="header d-lg-flex justify-content-between align-items-center">
					<!-- logo -->
					<h1 class="logo text-center">
						<a href="http://localhost:8080/springteam04/">MovieBOX</a>
					</h1>
					<div class="nav_w3ls">
						<nav>
							<label for="drop" class="toggle toogle-2">Menu</label> <input type="checkbox" id="drop" />
							<ul class="menu">
								<li class="active ml-0"><a href="http://localhost:8080/springteam04/">Home</a></li>
								<li><a href="http://localhost:8080/springteam04/movie/movieInfo">영화</a></li>
								<li><a href="http://localhost:8080/springteam04/reservation/reservePage01">예매</a></li>
								<c:if test="${empty authInfo}">
									<li><a href="http://localhost:8080/springteam04/member/loginForm"">My CGV</a></li>
									<li><a href="http://localhost:8080/springteam04/member/loginForm">로그인</a></li>
									<li><a href="http://localhost:8080/springteam04/member/joinForm">회원가입</a></li>
								</c:if>
								<c:if test="${!empty authInfo}">
									<li><a href="http://localhost:8080/springteam04/member/updateForm"">회원 정보</a></li>
									<li><a href="http://localhost:8080/springteam04/reservation/myReserveList"> ${authInfo.name}님 예매 확인</a></li>
									<li><a href="http://localhost:8080/springteam04/member/logout">로그아웃</a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</header>
	</div>