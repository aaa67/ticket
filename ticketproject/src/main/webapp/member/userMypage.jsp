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
<title>사용자 마이페이지</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&family=Nanum+Gothic&display=swap"
	rel="stylesheet">

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

.mypage::before{
    content: '';
	position: absolute;
	bottom: -10px;
	left: 10%;
	width: 80%;
	height: 3px;
	background-color: #FFFFFF;
	z-index: 1;
}

.logout::before, .signout::before {
	content: '';
	position: absolute;
	bottom: -10px;
	left: 0;
	width: 0;
	height: 3px;
	background-color: #FFFFFF;
	transition: width 0.8s;
	z-index: 1;
}

.logout:hover::before, .signout:hover::before {
	width: 100%;
}


.mypage, .logout, .signout {
	font-family: 'Jua', sans-serif;
	font-size: 22px;
	color: #FFFFFF;
	margin-left: auto;
	padding: 0 40px;
	position: relative;
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
	width: 100%; 
	height: 125px;
	background: #FF7575;
	top: 85px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.white-box {
	position: absolute;
	width: 50%;
	left: 25%;
	top: 301px;
	background: #FAFAFA;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25);
	border-radius: 30px 30px 0px 0px;
	padding: 20px; 
}

.white-box caption {
	font-family: 'Bagel Fat One';
	font-style: normal;
	font-weight: 400;
	font-size: 30px;
	line-height: 150px;
	display: flex;
	align-items: left;
	text-align: left;
}

.white-box table {
	width: 100%;
}

.white-box table tr {
	border-radius: 10px;
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2); 
	margin-bottom: 30px; 
	border-spacing: 30px 30px;
}

.white-box table tr th {
	padding: 20px; /* 셀 내부 여백 추가 */
	font-family: 'Jua', sans-serif;
	font-size: 14px;
	color: #000000;
}

.white-box table tr td {
	padding: 10px; 
	font-family: "Jua", sans-serif;
	font-size: 14px;
	color: #000000;
}

.white-box table tr td:first-child {
	width: 100px; 
}

.white-box table tr td.content {
	width: calc(100% - 100px); 
	padding: 10px;
}

.white-box table tr td img {
	max-width: 100%; 
	margin: auto;
	display: block;
}

.cancel {
    width:80px;
	font-family: 'Jua', sans-serif;
	font-size: 14px;
	background-color: #FF7575; 
	color: #FFFFFF; 
	border: none; 
	border-radius: 10px; 
	padding: 5px 10px; 
}

/* 버튼에 호버 효과를 추가할 경우 */
.cancel:hover {
	background-color: #D84315; 
	cursor: pointer; 
}

/* 왼쪽 메뉴 */
.left-align {
	position: absolute;
	top: 301px;
	left: -100px; 
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.left-align li {
	margin-bottom: 30px; 
}

.mypage2 {
	display: block;
	width: 330px; 
	height: 50px; 
	background-color: #FF7575; 
	border: none; 
	border-radius: 20px; 
	text-align: center;
	line-height: 50px; 
	font-family: 'Jua', sans-serif;
	font-size: 17px;
	color: #FFFFFF;
	text-decoration: none;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25); 
}

.edit {
	display: block;
	width: 330px; 
	height: 50px;
	background-color: #FAFAFA;
	border: none; 
	border-radius: 20px;
	text-align: center; 
	line-height: 50px; 
	font-family: 'Jua', sans-serif;
	font-size: 17px;
	color: #000000;
	text-decoration: none; 
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25); 
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
			<li><a href="${path}/member/signout" class="signout"> 회원 탈퇴 </a></li>
		</ul>
	</nav>

	<ul class="left-align">
		<li><a href="${path}/member/mypage" class="mypage2"> 예매내역 조회
				및 예매 취소 </a></li>
		<li><a href="${path}/member/edit" class="edit"> 개인정보 수정 </a></li>
	</ul>

	<div class="search"></div>

	<div class="white-box">
		<table>
			<tr>
				<th width=10>No.</th>
				<th width=50>공연명</th>
				<th width=50>가수명</th>
				<th width=65>공연 일자</th>
				<th width=150>공연장 위치</th>
				<th width=100>좌석 구역</th>
				<th width=100>좌석 번호</th>
				<th width=25>가격</th>
			</tr>
			<c:forEach var="ticket" items="${myTickets}">
				<tr>
					<td width=10>${ticket.ticketNum}</td>
					<td width=50>${ticket.performer}</td>
					<td width=50>${ticket.name}</td>
					<td width=65>${ticket.time}</td>
					<td width=150>${ticket.location}</td>
					<td width=100>${ticket.area}</td>
					<td width=100>${ticket.seat}</td>
					<td width=25>${ticket.price}</td>
					<td>
						<button
							onclick="location.href='${path}/ticket/cancel?ticketId=${ticket.ticketNum}'"
							class="cancel">예매 취소</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>