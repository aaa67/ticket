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
	width: 50%;
	left: 25%;
	top: 301px;
	background: #FAFAFA;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25);
	border-radius: 30px 30px 0px 0px;
	padding: 20px; /* 내부 여백 추가 */
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
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2); /* 오른쪽 테두리 외부 그림자 */
	margin-bottom: 30px; /* 각 행 사이 간격 조절 */
	border-spacing: 30px 30px;
}

.white-box table tr th {
	padding: 20px; /* 셀 내부 여백 추가 */
	font-family: 'Jua', sans-serif;
	font-size: 14px;
	color: #000000;
}

.white-box table tr td {
	padding: 10px; /* 셀 내부 여백 추가 */
	font-family: "Jua", sans-serif;
	font-size: 14px;
	color: #000000;
}

.white-box table tr td:first-child {
	width: 100px; /* 이미지 셀 너비 조절 */
}

.white-box table tr td.content {
	width: calc(100% - 100px); /* 텍스트 칸 너비 조절 */
	padding: 10px;
}

.white-box table tr td img {
	max-width: 100%; /* 이미지 크기 조절 */
	margin: auto;
	display: block;
}

.cancel {
    width:80px;
	font-family: 'Jua', sans-serif;
	font-size: 14px;
	background-color: #FF7575; /* 배경색 지정 */
	color: #FFFFFF; /* 글자색 지정 */
	border: none; /* 테두리 없애기 */
	border-radius: 10px; /* 모서리 둥글게 */
	padding: 5px 10px; /* 내부 여백 추가 */
}

/* 버튼에 호버 효과를 추가할 경우 */
.cancel:hover {
	background-color: #D84315; /* 호버 시 배경색 변경 */
	cursor: pointer; /* 호버 시 커서 변경 */
}

/* 왼쪽 메뉴 */
.left-align {
	position: absolute;
	top: 301px;
	left: -100px; /* 조정 가능 */
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.left-align li {
	margin-bottom: 30px; /* 각 요소 사이 간격 조정 */
}

.mypage2 {
	display: block;
	width: 330px; /* 사각형의 너비 */
	height: 50px; /* 사각형의 높이 */
	background-color: #FF7575; /* 배경색 지정 */
	border: none; /* 테두리 없애기 */
	border-radius: 20px; /* 모서리 둥글게 */
	text-align: center; /* 텍스트 가운데 정렬 */
	line-height: 50px; /* 텍스트 수직 가운데 정렬 */
	font-family: 'Jua', sans-serif;
	font-size: 17px;
	color: #FFFFFF;
	text-decoration: none; /* 밑줄 제거 */
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25); /* 그림자 추가 */
}

.edit {
	display: block;
	width: 330px; /* 사각형의 너비 */
	height: 50px; /* 사각형의 높이 */
	background-color: #FAFAFA; /* 배경색 지정 */
	border: none; /* 테두리 없애기 */
	border-radius: 20px; /* 모서리 둥글게 */
	text-align: center; /* 텍스트 가운데 정렬 */
	line-height: 50px; /* 텍스트 수직 가운데 정렬 */
	font-family: 'Jua', sans-serif;
	font-size: 17px;
	color: #000000;
	text-decoration: none; /* 밑줄 제거 */
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25); /* 그림자 추가 */
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