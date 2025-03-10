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
<title>메인</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&display=swap"
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

.admin, .user {
	font-family: 'Jua', sans-serif;
	font-size: 22px;
	color: #FFFFFF;
	margin-left: auto;
	padding: 0 40px;
	position: relative; 
}

.admin::before, .user::before {
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

.admin:hover::before, .user:hover::before {
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

/* 공연정보 */
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
	box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.2);
	margin-bottom: 30px;
	border-spacing: 30px 30px;
}

.white-box table tr td {
	padding: 20px;
	font-family: 'Jua', sans-serif;
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

.white-box table tr td a {
	color: #000000;
	text-decoration: none !important;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#search").on("click", f1);
	});

	function f1() {
		var search_name = $("#searchName").val();
		$.ajax({
			url : "${path}/search",
			type : "get",
			data : {
				"name" : search_name
			},
			success : function(responseData) {
				console.log(responseData)
				$("#here").html(responseData);
			},
			error : function(xhr, status, error) {
				console.log(xhr);
				console.log(status);
				alert(error); //Ajax가 실패 ex)보안 실패, 주소 오류
			}
		});
	}
</script>

</head>

<!-- <a href="${path}/detail?id=${show.id}"> -->

<body>
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

	<div class="search">
		<input type="text" id="searchName" placeholder="공연명 혹은 가수명을 입력하세요">
		<button id="search">
			<img src="${path}/static/image/search.png" alt="search">
		</button>
	</div>

	<div id="here" class="white-box">
		<table>
		<caption>공연 목록</caption>
			<c:forEach var="show" items="${showlist}">
				<tr>
					<td width=300 height=100 style='table-layout:fixed'><img src="${path}/upload/${show.image}" alt="show image"></td>
					<td width=300 height=100 style='word-break:break-all;' class="content">${show.performer}<br><br>${show.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>