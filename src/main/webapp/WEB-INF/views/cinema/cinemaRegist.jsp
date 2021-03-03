<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<style type="text/css">
#cinemaRegist {
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
	<form:form  method="post"  modelAttribute="cinemaVO"   id="cinemaRegist">
		<br />
		<h3 class="title-w3pvt mb-10" id="title" style="font-size: 35px;">지점 등록 🏡</h3>
		<br/><br/>
		<div class="form-group">
			<form:hidden path="cinema_code" class="form-control" placeholder="지점 코드"/>
			<br />
			<form:select path="cinema_location" class="form-control"  placeholder="지역 선택" >
				<form:option value="서울"/>
				<form:option value="경기"/>
			</form:select>
			<br />
			<form:input path="cinema_name" class="form-control"  placeholder="지점명 ex)OO점" />
			<br />
			<form:input path="cinema_info" class="form-control"  placeholder="지점 주소"/>
			<br/>
			<br /> <br /> 
			<input type="submit" class="btn btn-dark" value="등록" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>