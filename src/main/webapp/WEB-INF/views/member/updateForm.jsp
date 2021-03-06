<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style type="text/css">
#updateform {
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
	<form:form method="post" modelAttribute="memberVO"  id="updateform">
		<br />
		<h3 class="title-w3pvt mb-10" id="title">Update Profile🎬</h3>

		<div class="form-group">
			<form:input path="id" class="form-control" value="${member.id}" readonly="true" />
			<br />
			<form:password path="password" class="form-control" placeholder="비밀번호" />
			<br />
			<form:input path="name" class="form-control"  value="${member.name}" />
			<br />
			<form:input path="email" class="form-control"  value="${member.email}" />
			<br />
			<form:input path="birth" class="form-control"  value="${member.birth}"  readonly="true" />
			<br /> <br /> <input type="submit" class="btn btn-primary" value="정보 수정" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>