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
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
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

.mypage2, .edit {
	font-family: 'Jua', sans-serif;
	font-size: 22px;
	color: #FFFFFF;
}

/* 공연예매 링크 스타일 */
.main {
	text-align: center;
	margin-top: 20px;
	font-family: 'Bagel Fat One', sans-serif;
	font-size: 30px;
	color: #FFFFFF;
}

/* 검색창 */
.search {
	position: absolute;
	width: 100%; /* 화면에 꽉 차도록 설정 */
	height: 125px;
	background: #FF7575;
	top: 85px; /* 이전 요소와의 간격 조정 */
	display: flex;
	justify-content: center;
	align-items: center;
}

.white-box {
	position: absolute;
	width: 450px;
	height: 550px;
	left: 35%;
	top: 301px;
	background: #FAFAFA;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25);
	border-radius: 30px;
	padding: 20px;
	display: flex;
	justify-content: center;
	flex-direction: column;
}

.white-box h3 {
	margin-left: 30px;
	font-family: 'Bagel Fat One', sans-serif;
	font-size: 30px;
	color: #000000; /* 검은색 */
	margin-top: 20px;
	margin-bottom: 10px;
}

/* 각 좌석 버튼 */
.white-box button {
	width: 30px;
	height: 30px;
	margin: 5px;
	border: none;
	border-radius: 10px;
	cursor: pointer;
}

/* 1층 좌석 버튼 */
.white-box .first {
	background-color: #7C4FFF; /* 보라색 */
}

/* 2층 좌석 버튼 */
.white-box .second {
	background-color: #FF9776; /* 주황색 */
}

/* 3층 좌석 버튼 */
.white-box .third {
	background-color: #FFF389; /* 노란색 */
}

/* 예매 불가능 좌석 표시 */
.white-box .X {
	background-color: #CCCCCC; /* 회색 */
}

.white-box .seat-row {
	display: flex;
	flex-wrap: wrap;
	margin-bottom: 10px;
}

.seat-row button {
	margin: 30px;
}
</style>

</head>
<body>
	<nav class="topmenu">
		<ul class="nav">
			<li><a href="${path}/member/main"><img
					src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			<li><a href="${path}/member/main" class="main"> 공연예매 </a></li>
		</ul>
		<ul class="nav right-align">
			<li><a href="${path}/member/mypage" class="mypage"> 마이페이지 </a></li>
			<li><a href="${path}/logout" class="logout"> 로그아웃 </a></li>
			<li><a href="${path}/member/signout" class="signout"> 회원 탈퇴
			</a></li>
		</ul>
	</nav>

	<c:set var="tPath"
		value="${pageContext.request.servletContext.contextPath}/ticket?showId=${showId}" />

	<div class="search"></div>

	<div class="white-box">
		<br>
		<h3>1층</h3>
		<div class="seat-row">
			<c:forEach var="seat" items="${seatList}">
				<c:if test="${seat.area eq '1층' and seat.status eq '예매 가능'}">
					<a href="${tPath}&area=${seat.area}&seat=${seat.seat}">
						<button class="first O"></button>
					</a>
				</c:if>
				<c:if test="${seat.area eq '1층' and seat.status eq '예매 불가능'}">
					<button class="X"></button>
				</c:if>
			</c:forEach>
		</div>
		<h3>2층</h3>
		<div class="seat-row">
			<c:forEach var="seat" items="${seatList}">
				<c:if test="${seat.area eq '2층' and seat.status eq '예매 가능'}">
					<a href="${tPath}&area=${seat.area}&seat=${seat.seat}">
						<button class="second O"></button>
					</a>
				</c:if>
				<c:if test="${seat.area eq '2층' and seat.status eq '예매 불가능'}">
					<button class="X"></button>
				</c:if>
			</c:forEach>
		</div>
		<h3>3층</h3>
		<div class="seat-row">
			<c:forEach var="seat" items="${seatList}">
				<c:if test="${seat.area eq '3층' and seat.status eq '예매 가능'}">
					<a href="${tPath}&area=${seat.area}&seat=${seat.seat}">
						<button class="third O"></button>
					</a>
				</c:if>
				<c:if test="${seat.area eq '3층' and seat.status eq '예매 불가능'}">
					<button class="X"></button>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>