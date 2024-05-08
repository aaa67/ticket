<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공연 예매</title>

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

.search-container {
    position: relative;
}

.search input[type="text"] {
    box-sizing: border-box;
    width: calc(100% - 360px); /* 버튼을 고려한 너비 조절 */
    height: 49px;
    padding: 0 20px;
    margin-left: 20px; /* 왼쪽 여백 조절 */
    background: #F2F2F2;
    border: 1px solid #FFFFFF;
    border-radius: 25px;
    font-family: 'Noto Sans', sans-serif;
    font-size: 14px;
    color: #B2B2B2;
    outline: none; /* 포커스 시 테두리 제거 */
}

.search button {
    position: absolute;
    top: 50%;
    right: 200px; /* 오른쪽 여백 조절 */
    transform: translateY(-50%);
    width: 40px;
    height: 40px;
    border: none;
    background: #F2F2F2;
    border-radius: 20px;
    cursor: pointer;
}

.search button img {
    width: 20px; /* 이미지 크기 조절 */
    height: auto;
    margin: 10px; /* 이미지 내부 여백 추가 */
}

</style>

    
</head>

<body>
	<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}" />
		
	<nav class="topmenu">
		<ul class="nav">
            <li><a href=""><img src="static/image/logo.png" alt="logo" class="logo"></a></li>
			 <li><a href="" class="main"> 공연예매 </a></li>
			 </ul>
        <ul class="nav right-align"> 
			<li><a href="auth/adminLogin.jsp" class="admin"> 관리자 </a></li>
			<li><a href="auth/userLogin.jsp" class="user"> 사용자 </a></li>
		</ul>
	</nav>

	<div class="search">
		<input type="text" placeholder="공연명 혹은 가수명을 입력하세요">
		<button type="button">
			<img src="static/image/search.png" alt="search">
		</button>
	</div>

	<table border="1">
		<c:forEach var="show" items="${showlist}">
			<tr>
				<td><a href="${path}/showList"><img
						src="" alt="show image"></a></td>
				<td>${show.performer}</td>
				<td>${show.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>