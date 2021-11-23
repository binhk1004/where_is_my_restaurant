<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<link type="text/css" rel='stylesheet' href=<c:url value="/resources/css/home.css"/>/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<title>Home</title>
</head>
<body>
	<div id="search-area" class="search-area">
		<form action="Map" method="get" class="search-bar">
			<div class=>
				<input type="text" class="form-control input-lg" placeholder="지역과 음식명을 입력해주세요!" name="localName">
			</div>
		</form>
	</div>
	<div class="video-area">
		<video autoplay muted loop>
			<source src="<c:url value="/resources/video.mp4"/>">
		</video>
	</div>
</body>
</html>
