<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 회원가입</title>

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

.admin::before{
    content: '';
	position: absolute;
	bottom: -10px;
	left: 10%;
	width: 80%;
	height: 3px;
	background-color: #FFFFFF;
	z-index: 1;
}

.admin, .user {
	font-family: 'Jua', sans-serif;
	font-size: 22px;
	color: #FFFFFF;
	margin-left: auto;
	padding: 0 40px;
	position: relative;
}

.user::before {
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

.user:hover::before {
	width: 100%; 
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
	width: 100%; 
	height: 125px;
	background: #FF7575;
	top: 85px; 
	display: flex;
	justify-content: center;
	align-items: center;
}

/* 회원가입 */
.white-box {
	position: absolute;
	width: 500px;
	height: 500px;
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

.email label, .password label {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	color: #000000;
	margin-bottom: 10px;
	margin-left: 10px;
}

.einput, .pinput {
	width: 450px;
	height: 50px;
	background: #FAFAFA;
	border-top: none;
	border-left: none;
	border-right: none;
	border-bottom: 1px solid black;
	margin-bottom: 20px;
	margin-left: 10px;
}

.signup {
	font-family: "Nanum Gothic", sans-serif;
	font-weight: 400;
	font-style: normal;
	font-color: #000000;
	position: absolute;
	width: 70px;
	left: 45%;
	top: 75%;
	background: #FFFFFF;
	background: #FFFFFF;
	border-radius: 15px;
	border: 1px solid black;
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
			<li><a href="${path}/main"><img
					src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			<li><a href="${path}/main" class="main"> 공연예매 </a></li>
		</ul>
		<ul class="nav right-align">
			<li><a href="${path}/admin/login" class="admin"> 관리자 </a></li>
			<li><a href="${path}/member/login" class="user"> 사용자 </a></li>
		</ul>
	</nav>
	
	<div class="search"></div>

	<div class="white-box">
		<form action="signup" method="post">
			<div class="email">
				<label for="email">이메일:</label> <br> <input type="text"
					class="einput" id="email" name="id">
			</div>
			<br> <br>
			<div class="password">
				<label for="pw">비밀번호:</label><br> <input type="password"
					class="pinput" id="pw" name="pw">
			</div>
			<button type="submit" class="signup">회원가입</button>
		</form>
	</div>
	<script src="../static/js/jquery-3.7.1.min.js"></script>
</body>
</html>