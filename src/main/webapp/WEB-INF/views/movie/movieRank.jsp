<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="banner-w3ls-bottom py-5" id="part">
	<div>
		<div class="header-w3layouts text-center mb-5">
			<h3 class="title-w3pvt mb-20">
				<a>🏆Top5 Movie Rank🏆</a>
			</h3>
		</div>
		<div class="row part-grids">
			<c:forEach items="${countList}" var="map" varStatus="st">
				<c:forEach items="${movieList}" var="movie" varStatus="status">
					<c:if test="${map.movie_code eq movie.movie_code}">
						<div id="div" class="m-5">
							<c:choose>
								<c:when test="${st.count eq 1 }">
									<h4 class="mt-4" style="font-weight: bold">🥇Rank ${st.count}위</h4>
								</c:when>
								<c:when test="${st.count eq 2 }">
									<h4 class="mt-4" style="font-weight: bold">🥈Rank ${st.count}위</h4>
								</c:when>
								<c:when test="${st.count eq 3 }">
									<h4 class="mt-4" style="font-weight: bold">🥉Rank ${st.count}위</h4>
								</c:when>
								<c:otherwise>
									<h4 class="mt-4" style="font-weight: bold">Rank ${st.count}위</h4>
								</c:otherwise>
							</c:choose>
							<img src="images/${movie.movie_poster}" alt="part image" class="img-fluid" height="330px" width="210px">
							<h4 class="mt-4" style="font-weight: bold">${movie.movie_sub}</h4>
							<p class="mt-3"><%-- 예매수 : ${map.cnt} --%></p>
							<input type="button" class="btn btn-dark"  value="예매" id="subBtn"  onclick="#" style="width:190px"/>
						</div>
					</c:if>
				</c:forEach>
			</c:forEach>
		</div>
	</div>
</section>