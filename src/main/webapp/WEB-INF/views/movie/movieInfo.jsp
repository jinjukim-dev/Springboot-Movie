<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<!-- // All Movie 부분 -->
	<section class="banner-w3ls-bottom py-5" id="part">
		<div>
			<div class="header-w3layouts text-center mb-5">
				<h3 class="title-w3pvt mb-20">
					<a>All Movies 🎬</a>
				</h3>
			</div>
			<div class="row part-grids">
			<c:forEach var="list"  items="${movieList}" varStatus="status">
				<div id="div" class="m-5">
					<img src="../images/${list.movie_poster}" alt="movie_poster"  height="330px" width="210px">
					<h5 class="mt-4">${list.movie_sub}</h5>
					<p class="mt-3">영화 예매율, ${list.movie_open}</p>
					<input type="button" class="btn btn-dark"  value="예매" id="subBtn"  onclick="#" style="width:190px"/>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>