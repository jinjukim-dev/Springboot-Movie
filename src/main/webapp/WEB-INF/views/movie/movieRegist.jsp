<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css">
#movieRegist {
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
	<form:form  method="post" modelAttribute="movieVO"   id="movieRegist">
		<br />
		<h3 class="title-w3pvt mb-10" id="title" style="font-size: 35px;">영화 등록🎬</h3>
		<br/><br/>
		<div class="form-group">
			<form:input path="movie_sub" class="form-control" placeholder="영화 제목"/>
			<br />
			<form:input path="movie_direc" class="form-control"  placeholder="감독 성함" />
			<br />
			<form:input path="movie_gen" class="form-control"  placeholder="영화 장르" />
			<br />
			<form:input path="movie_open" class="form-control"  placeholder="개봉일"/>
			<br/>
			<form:input path="movie_age" class="form-control"  placeholder="관람연령제한"/>
			<br />
			<form:input path="movie_time" class="form-control"  placeholder="러닝타임(분)" />
			<br />
			<form:input type="file" path="movie_poster" class="form-control"  placeholder="영화 포스터" />
			<br />
			<br /> <br /> 
			<input type="submit" class="btn btn-dark" value="등록" id="subBtn" />
		</div>
	</form:form>
</div>
<br/><br/>