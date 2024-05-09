<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"
	value="${pageContext.request.servletContext.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>좌석 정보</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<!-- <style>
body {
    margin: 0;
    padding: 0;
}

.topmenu {
    background: #000000;
    height: 85px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 20px;
}

.nav {
    list-style-type: none;
    margin: 0;
    padding: 0;
    display: flex;
    align-items: center;
}

.logo {
    width: 60px; 
    padding-left: 20px;
}

.nav li {
    margin-right: 20px;
}

.nav li:last-child {
    margin-right: 0;
}

.nav a {
    color: #FFFFFF;
    text-decoration: none;
}

.mypage, .logout, .signout {
    font-family: 'Jua', sans-serif;
    font-size: 22px;
    color: #FFFFFF;
    margin-left: auto;
    padding: 0 40px;
    
}

/* 공연예매 링크 스타일 */
.main {
    text-align: center;
    margin-top: 20px;
    font-family: 'Bagel Fat One', sans-serif;
    font-size: 30px;
    color: #FFFFFF;
}
</style><-->

</head>
<body>
<nav class="topmenu">
		<ul class="nav">
			<li><a href="${path}/main"><img
					src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			<li><a href="${path}/main" class="main"> 공연예매 </a></li>
		</ul>
		<ul class="nav right-align">
			<li><a href="${path}" class="mypage"> 마이페이지 </a></li>
			<li><a href="${path}/logout" class="logout"> 로그아웃 </a></li>
			<li><a href="${path}" class="signout"> 회원 탈퇴 </a></li>
		</ul>
	</nav>

	<h3>1층</h3>
	<c:forEach var="seat" items="${seatList}">
		<c:if test="${seat.area eq '1층' and seat.status eq '예매 가능'}">
			<button class="first O"></button>
		</c:if>
		<c:if test="${seat.area eq '1층' and seat.status eq '예매 불가능'}">
			<button class="first X"></button>
		</c:if>
	</c:forEach>
	<h3>2층</h3>
	<c:forEach var="seat" items="${seatList}">
		<c:if test="${seat.area eq '2층' and seat.status eq '예매 가능'}">
			<button class="second O"></button>
		</c:if>
		<c:if test="${seat.area eq '2층' and seat.status eq '예매 불가능'}">
			<button class="second X"></button>
		</c:if>
	</c:forEach>
	<h3>3층</h3>
	<c:forEach var="seat" items="${seatList}">
		<c:if test="${seat.area eq '3층' and seat.status eq '예매 가능'}">
			<button class="third O"></button>
		</c:if>
		<c:if test="${seat.area eq '3층' and seat.status eq '예매 불가능'}">
			<button class="third X"></button>
		</c:if>
	</c:forEach>
</body>
</html>