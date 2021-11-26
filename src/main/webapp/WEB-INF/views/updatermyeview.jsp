<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="com.binhk.model.RestautantVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<%
RestautantVO pvo 
		= (RestautantVO)request.getAttribute("update");
%>   

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/updatemyreview.css"/>/>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <title>리뷰수정</title>
    </head>
    <body>
        <div>
        	<div class="title">
        		<h1>리뷰를 수정해주세요.</h1>
        	</div>
            <form method="post" action="">
            <div class="form">
            	<div class="form-group">
		           	<div class="star-rating">
			        <input type="radio" id="5-stars" class='fivestars'  name="star" value="5" />
			        <label for="5-stars" class="star">&#9733;</label>
			        <input type="radio" id="4-stars" class='fourstars' name="star" value="4" />
			        <label for="4-stars" class="star">&#9733;</label>
			        <input type="radio" id="3-stars" class='threestars' name="star" value="3" />
			        <label for="3-stars" class="star">&#9733;</label>
			        <input type="radio" id="2-stars" class='twostars' name="star" value="2" />
			        <label for="2-stars" class="star">&#9733;</label>
			        <input type="radio" id="1-star" class='onestar' name="star" value="1" />
			        <label for="1-star" class="star">&#9733;</label>
		    	</div>
    				<input type="hidden" id='checkstar'  name="star" class="form-control" value="<%=pvo.getStar() %>">
  				</div>
  				<div class="form-group">
    				<textarea class="form-control" name="review" rows="3" ><%=pvo.getReview() %></textarea>
  				</div>
  			</div>
                <div class="button">
	                <button type="submit" class="btn btn-primary">작성완료</button>
	                <button type="reset" class="btn btn-primary">리셋하기</button>
	                <button type="reset" class="btn btn-primary" onclick="history.back()">목록으로</button>
                </div>
                      
                </form>
            </div>

        </body>
        <script>
			checkStar = () => {
				var star = $('.form-control').val();

				if(star == 1){
					document.querySelector('.onestar').setAttribute('checked',true);
				}
				else if(star == 2){
					document.querySelector('.twostars').setAttribute('checked',true);
				}
				else if(star == 3){
					document.querySelector('.threestars').setAttribute('checked',true);
				}
				else if(star == 4){
					document.querySelector('.fourstars').setAttribute('checked',true);
				}
				else {
					document.querySelector('.fivestars').setAttribute('checked',true);
				}
			}

			$("#checkstar").val(checkStar)
        </script>
    </html>