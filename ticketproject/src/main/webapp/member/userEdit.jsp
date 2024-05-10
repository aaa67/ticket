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
			<li><a href="${path}/member/mypage" class="mypage"> 마이페이지 </a></li>
			<li><a href="${path}/logout" class="logout"> 로그아웃 </a></li>
			<li><a href="${path}" class="signout"> 회원 탈퇴 </a></li>
		</ul>
		<ul class="nav left-align">
			<li><a href="${path}/member/mypage" class="mypage"> 예매내역 조회
					및 예매 취소 </a></li>
			<li><a href="${path}/member/edit" class="edit"> 개인정보 수정 </a></li>
		</ul>
	</nav>

	<table border="1">
		<tr>
			<th>예매 번호</th>
			<th>공연명</th>
			<th>가수명</th>
			<th>공연 일자</th>
			<th>공연장 위치</th>
			<th>좌석 구역</th>
			<th>좌석 번호</th>
			<th>가격</th>
		</tr>
		<c:forEach var="ticket" items="${myTickets}">
			<tr>
				<td>${ticket.ticketNum}</td>
				<td>${ticket.performer}</td>
				<td>${ticket.name}</td>
				<td>${ticket.time}</td>
				<td>${ticket.location}</td>
				<td>${ticket.area}</td>
				<td>${ticket.seat}</td>
				<td>${ticket.price}</td>
				<td>
				<button onclick="location.href='${path}/ticket/cancel?ticketId=${ticket.ticketNum}'" class="cancel">예매 취소</button>
				</td>
			</tr>
		</c:forEach>
	</table>

<div class="edit">
  <form action="edit" method="post">
  <label>새 정보 입력</label>
      <label for="pw">새 비밀번호 입력</label>
      <input type="text" class="form-control" value="" id="pw" name="pw">
      <label for="ad">새 주소 입력</label>
      <input type="text" class="form-control" value="" id="ad" name="ad">
    <button type="submit" class="login">수정</button>
  </form>
</div>

</body>
</html>