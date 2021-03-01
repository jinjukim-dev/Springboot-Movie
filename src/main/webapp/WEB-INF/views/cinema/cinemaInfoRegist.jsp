<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
#cinemaRoom {
	margin: 0 auto;
	width: 600px;
}

#subBtn {
	margin: 0 auto;
	width: 100px;
}
</style>
<br/><br/>
<div class="container">
	<form:form  action="cinemaRoomRegist" method="post" modelAttribute="cinemaRoomVO"   id="cinemaRoom">
		<br />
		<h3 class="title-w3pvt mb-10" id="title">상영관 등록🪑</h3>
		<br/><br/>
		<div class="form-group">
			<form:hidden path="cinema_code" class="form-control" placeholder="지점 코드"/>
			<form:input path="cinema_room" class="form-control" placeholder="상영관 ex)6관"/>
			<br />
			<form:input path="seat_qnt" class="form-control"  placeholder="좌석수" />
			<br />
			<br /> <br /> 
			<input type="submit" class="btn btn-dark" value="등록" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>