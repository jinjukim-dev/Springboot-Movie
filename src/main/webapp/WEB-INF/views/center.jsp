<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- //center 부분 -->
	<!-- //메인사진 부분 -->
	<div class="main-content" id="home">
		<div class="container">
			<div class="banner-info text-left">
				<h3>What's your favorite movie?</h3>
			</div>
		</div>
	</div>
	
	<!-- //박스오피스 부분 -->
	<%@ include file="./movie/movieRank.jsp" %>