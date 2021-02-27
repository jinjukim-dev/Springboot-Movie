<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style type="text/css">
#joinform {
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
	<form:form method="post" modelAttribute="memberVO"  id="joinform">
		<br />
		<h3 class="title-w3pvt mb-10" id="title">Join MovieBOX🎬</h3>
		<div class="form-group">
			<form:input path="id" class="form-control" placeholder="아이디" />
			<form:errors path="id" />
			<br />
			<form:password path="password" class="form-control" placeholder="비밀번호" />
			<form:errors path="password" />
			<br />
			<form:input path="name" class="form-control" placeholder="이름" />
			<form:errors path="name" />
			<br />
			<form:input path="email" class="form-control" placeholder="이메일" />
			<form:errors path="email" />
			<br /> <br /> <input type="submit" class="btn btn-primary" value="가입하기" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>