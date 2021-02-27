<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
#loginForm {
	margin: 0 auto;
	width: 600px;
}

#logBtn {
	margin: 0 auto;
	width: 100px;
}
</style>
<br/><br/>
<div class="container">
	<form:form modelAttribute="loginCommand" id="loginForm">
		<c:if test="${empty authInfo}">
			<div class="form-group">
				<label>아이디</label>
				<form:input path="id" class="form-control" />
				<form:errors path="id" />
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" />
				<form:errors />
			</div>
			<input type="submit" class="btn btn-primary" value="로그인" id="logBtn" />
		</c:if>
</div>
</form:form>
<br/><br/>
</div>