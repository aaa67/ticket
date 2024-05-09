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
<title>공연 예매</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap"
	rel="stylesheet">

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



</style>-->

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>

<body>

	<nav class="topmenu">
		<ul class="nav">
			<li><a href="${path}/main"><img
					src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			<li><a href="${path}/main" class="main"> 공연예매 </a></li>
		</ul>
		<ul class="nav right-align">
			<li><a href="${path}/admin/show" class="add"> 공연 추가 </a></li>
			<li><a href="${path}/logout" class="logout"> 로그아웃 </a></li>
			<li><a href="${path}/admin/signout" class="signout"> 회원 탈퇴 </a></li>
		</ul>
	</nav>
	<div>
		<form action="signout" method="post">
			<label for="pw">비밀번호:</label> <input type="password"
				class="form-control" id="pw" name="pw">
			<button type="submit" class="signout">탈퇴</button>
		</form>
	</div>
</body>
</html>