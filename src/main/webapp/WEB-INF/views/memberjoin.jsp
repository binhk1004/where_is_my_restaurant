<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 페이지</title>
<link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/memberjoin.css"/>/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

</head>
<body>
	<div>
	<form method="post" action="">
		<div class="title">
			<h3>회원가입을 해주세요.</h3>
		</div>
		<div class="form-floating">
			<div class="memeberform">
	            <label> 아이디 : </label>
	            <input class="form-control" name="memberId" placeholder="아이디" id="floatingTextarea2" ></input>
            </div>
            <div class="memeberform">
	            <label> 비밀번호 : </label>
	            <input class="form-control" name="memberPw" type="password" placeholder="비밀번호" id="floatingTextarea2"></input>
	       	</div>
	       	<div class="memeberform">
	            <label> 이름 : </label>
	            <input class="form-control" name="memberName" placeholder="이름" id="floatingTextarea2"></input>
	        </div>
	        <div class="memeberform">
	            <label> 연락처 : </label>
	            <input class="form-control" name="memberPhone" placeholder="연락처" id="floatingTextarea2"></input>
	        </div>
        </div>
        <div class="button">
	        <button type="submit" class="btn btn-primary">등록</button>
	    </div>
    </form>
	</div> 
</body>
</html>