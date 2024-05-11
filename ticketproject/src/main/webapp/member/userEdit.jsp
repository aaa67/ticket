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
<title>개인정보 수정</title>
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
	width: 500px;
	height: 300px;
	left: 35%;
	top: 301px;
	background: #FAFAFA;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.25);
	border-radius: 30px;
	padding: 20px; /* 내부 여백 추가 */
	display: flex; /* 내부 요소들을 수평으로 정렬하기 위해 flex 사용 */
	justify-content: center; /* 내부 요소들을 가운데로 정렬 */
	flex-direction: column; /* 내부 요소들을 수직으로 정렬 */
}

.password label, .address label {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	color: #000000;
	margin-bottom: 10px; /* label 간격 조절 */
	margin-left: 10px;
}

.pinput, .ainput {
	width: 450px;
	height: 50px;
	background: #FAFAFA;
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: 1px solid black;
	margin-bottom: 20px; /* input 간격 조절 */
	margin-left: 10px;
}

.editButton {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	font-color: #000000;
	position: absolute;
	width: 70px;
	right: 40px;
	bottom: 20px;
	background: #FFFFFF;
	border-radius: 15px;
	border: 1px solid black;
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

.edit {
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

.center-label {
	text-align: center;
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

	<ul class="left-align">
		<li><a href="${path}/member/mypage" class="mypage2"> 예매내역 조회
				및 예매 취소 </a></li>
		<li><a href="${path}/member/edit" class="edit"> 개인정보 수정 </a></li>
	</ul>

	<div class="search"></div>

	<div class="white-box">
		<form action="edit" method="post">
			<div class="center-label">
				<label>새 정보 입력</label>
			</div>
			<div class="password">
				<br>
				<label for="pw">새 비밀번호 입력</label><br> <input type="text"
					class="pinput" id="pw" name="pw">
			</div>

			<div class="address">
				<label for="ad">새 주소 입력</label><br> <input type="text"
					class="ainput" id="ad" name="ad">
			</div>

			<button type="submit" class="editButton">수정</button>
		</form>
	</div>

</body>
</html>