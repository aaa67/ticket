<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공연 추가 화면</title>

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

.add, .logout, .signout {
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

/* 회원가입 */
.white-box {
	position: absolute;
	width: 500px;
	height: 650px;
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

.performer label, .name label, .location label, .age label, .time label, .image label {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	color: #000000;
	margin-bottom: 10px; /* label 간격 조절 */
	margin-left: 10px;
}

.pinput, .ninput, .linput, .ainput, .tinput, .iinput {
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

.insert {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	font-color: #000000;
	position: absolute;
	width: 70px;
	right: 40px; 
	bottom: 40px; 
	background: #FFFFFF;
	border-radius: 15px;
	border: 1px solid black;
}
</style>

</head>
<body>

<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}" />

<nav class="topmenu">
		<ul class="nav">
			<li><a href="${path}/admin/main"><img
					src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			<li><a href="${path}/admin/main" class="main"> 공연예매 </a></li>
		</ul>
		<ul class="nav right-align">
			<li><a href="${path}/admin/show" class="add"> 공연 추가 </a></li>
			<li><a href="${path}/logout" class="logout"> 로그아웃 </a></li>
			<li><a href="${path}/admin/signout" class="signout"> 회원 탈퇴 </a></li>
		</ul>
	</nav>
	<div class="search"></div>

<div class="white-box">
  <form action="show" enctype="multipart/form-data" method="post">
  
  <div class="performer">
      <label for="performer">가수명</label>
      <input type="text" class="pinput" id="performer" name="performer">
      </div>
      
      <div class="name">
      <label for="name">공연명</label>
      <input type="text" class="ninput" id="name" name="name">
      </div>
      
      <div class="location">
      <label for="location">장소</label>
      <input type="text" class="linput" id="location" name="location">
      </div>
      
      <div class="age">
      <label for="age">연령등급</label>
      <input type="number" class="ainput" id="age" name="age">
      </div>
      
      <div class="time">
      <label for="time">공연일자</label>
      <input type="date" class="tinput" id="time" name="time">
      </div>
      
      <div class="image">
      <label for="image">공연 이미지</label>
      <input type="file" class="iinput" id="image" name="image">
      </div>
      
    <button type="submit" class="insert">공연 추가</button>
  </form>
</div>
<script src="../static/js/jquery-3.7.1.min.js"></script>