<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/memberjoin.css"/>/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
	<div>
	<form method="post" action="">
		<div class="title">
			<h3>로그인을 해주세요.</h3>
		</div>
		<div class="form-floating">
			<div class="memeberform">
	            <label> 아이디 : </label>
	            <input class="form-control" type="text" name="member_id" placeholder="아이디" id="floatingTextarea2" ></input>
            </div>
            <div class="memeberform">
	            <label> 비밀번호 : </label>
	            <input class="form-control" type="password" name="member_pw" placeholder="비밀번호" id="floatingTextarea2"></input>
	       	</div>
        </div>
        <div class="button">
	        <button type="submit" class="btn btn-primary">로그인하기</button>
	    </div>
    </form>
	</div>

</body>
</html>