<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%-- <%@ page session="false" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/createreview.css"/>/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>리뷰등록</title>
</head>
<body>
	<div>
		<div class="title">
	   		<h3>별점과 후기를 입력해주세요.</h3>
	   	</div>
	    <form method="post" action="" >
		    <div class="star-rating">
		        <input type="radio" id="5-stars" name="star" value="5" />
		        <label for="5-stars" class="star">&#9733;</label>
		        <input type="radio" id="4-stars" name="star" value="4" />
		        <label for="4-stars" class="star">&#9733;</label>
		        <input type="radio" id="3-stars" name="star" value="3" />
		        <label for="3-stars" class="star">&#9733;</label>
		        <input type="radio" id="2-stars" name="star" value="2" />
		        <label for="2-stars" class="star">&#9733;</label>
		        <input type="radio" id="1-star" name="star" value="1" />
		        <label for="1-star" class="star">&#9733;</label>
		    </div>
		    <div class="form">
		        <div class="form-group">
		            <input type="text"  name="name" class="form-control" value='상호명: <%= request.getParameter("name") %>' aria-label="readonly input example" readonly>
		        </div>
		        <div class="form-group">
		            <input type="text"  name="address" class="form-control" value='주소명: <%= request.getParameter("address")%>' aria-label="readonly input example" readonly>
		            <input type="hidden" name="memberNum" value="${memberNum}"/>
		        </div>
		        <div class="form-floating">
		            <textarea class="form-control" name="review" placeholder="리뷰를 등록해주세요." id="floatingTextarea2" style="height: 100px"></textarea>
		        </div>
		    </div>
		    <div class="button">
		        <button type="submit" class="btn btn-primary">등록</button>
		    </div>
	    </form>
    </div>
</body>
</html>