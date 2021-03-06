<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>영화 예매 페이지-1</title>

<script type="text/javascript">
	/* 선택값이 따른 지점 정보 보여주기 */
 	$(document).ready(function(){
 		
 		$("input:radio[name=optradio]").on('change', function(){
 			var movie_code = $(this).attr('value');
 			alert("선택한 movie_code : "+movie_code);
 			
 			$.ajax({
 				type: "POST",
 				url: "../getCinemaInfo/"+movie_code,
 				data : {
 					'movie_code' : movie_code
 				},
 				dataType: "json",
 				contentType: "aplication/json; charset=UTF-8",
 				success:function(data){
 					console.log("success"+JSON.stringify(data));
 					
 					var keys = Object.keys(data);
 					$("#radioCinema").empty(); //초기화
 					for(var i in keys){						
 						$('#radioCinema').append(
 								"<div class='form-check'><label class='form-check-label mb-2'><input type='radio' class='form-check-input'  id='optroom' name='optroom' value= ' "+keys[i]+" '+''>"+data[keys[i]]
 								+ "</label> </div>"
 								);
 					}					
 				}
 			});		
 		});   // 영화 선택 
 		
 		$("input:radio[name=optroom]").on('change', function(){
			var cinema_code = $(this).attr('value');
			alert("선택한 cinema_code : "+cinema_code);

		});// 지점 선택
		
 	});
	
</script>

<!-- 영화 정보 가져오기 -->
<div class="container">
	<br /><br />
	<h3 style="font-size: 32px; font-weight: bold;">영화 예매 🎬</h3>
	<br /><br />
	<table class="table">
		<thead>
			<tr>
				<th>영화</th>
				<th>지점</th>
				<th>상영관</th>
				<th>날짜</th>
				<th>시간</th>
			</tr>
		</thead>
		<tbody>
			<form>
			<tr>
				<td>
					<c:forEach var="list" varStatus="st" items="${scheduleList}">
						<div class="form-check">
							<label class="form-check-label mb-2"> 
								<input type="radio" class="form-check-input "  id="optradio" name="optradio" value="${list.movie_code}" >
										${list.movie_sub} - ${list.movie_age}
							</label>
						</div>
					</c:forEach>
				</td>
				<td>
					<div id="radioCinema">
						<!-- 영화 선택 값에 따라 지점 정보 들어옴 -->
					</div>
				</td>
				<td>
					<div id="radioCinemaroom">
						<!-- 지점 선택 값에 따라 상영관 정보 들어옴 -->
					</div>
				</td>
				<td></td>
				<td></td>
			</tr>
			</form>
		</tbody>
	</table>
	<center><input type="button" class="btn btn-dark" value="좌석 선택하러 가기"/></center>
	<br /><br />
<%--
	<h3 style="font-size: 32px; font-weight: bold;">선택 내역 확인하기 🧾</h3>
	<br /><br />
 	<form:form>
		<div class="form-group">
			<form:input path="" class="form-control" placeholder="영화제목"  readonly/>
			<br />
			<form:password path="" class="form-control" placeholder="지점"  readonly/>
			<br />
			<form:input path="" class="form-control" placeholder="상영관"  readonly/>
			<br />
			<form:input path="" class="form-control" placeholder="날짜"  readonly/>
			<br />
			<form:input path="" class="form-control" placeholder="시간"  readonly/>
		</div>
		<input type="button" class="btn btn-dark" value="예매하기"/>
	</form:form> --%>
	<br /><br />
</div>