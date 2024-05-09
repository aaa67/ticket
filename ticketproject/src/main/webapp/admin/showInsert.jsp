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
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap" rel="stylesheet">

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

.admin, .user {
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
</style>

</head>
<body>

<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}" />

<nav class="topmenu">
		<ul class="nav">
            <li><a href="${path}/main"><img src="${path}/static/image/logo.png" alt="logo" class="logo"></a></li>
			 <li><a href="${path}/main" class="main"> 공연예매 </a></li>
			 </ul>
        <ul class="nav right-align"> 
			<li><a href="${path}/admin/login" class="admin"> 관리자 </a></li>
			<li><a href="${path}/member/login" class="user"> 사용자 </a></li>
		</ul>
	</nav>

<div class="container mt-3">
  <form action="show" enctype="multipart/form-data" method="post">
      <label for="performer">가수명</label>
      <input type="text" class="form-control" id="performer" name="performer">
      <label for="name">공연명</label>
      <input type="text" class="form-control" id="name" name="name">
      
      <label for="location">장소</label>
      <input type="text" class="form-control" id="location" name="location">
      
      <label for="age">연령등급</label>
      <input type="int" class="form-control" id="age" name="age">
      
      <label for="time">공연일자</label>
      <input type="date" class="form-control" id="time" name="time">
      
      <label for="image">공연 이미지</label>
      <input type="file" class="form-control" id="image" name="image">
      
    <button type="submit" class="signup">공연 추가</button>
  </form>
</div>
<script src="../static/js/jquery-3.7.1.min.js"></script>