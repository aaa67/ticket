<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연 예매</title>

<!--<style>
.topmenu {
	position: absolute;
	width: 1920px;
	height: 94px;
	left: 0px;
	top: 0px;
	background: #000000;
}

.logo {
	position: absolute;
	width: 54px; height : 54px; left : 30px;
	top: 20px;
	height: 54px;
	left: 30px;
}

.main {
	position: absolute;
	width: 149px;
	height: 51px;
	left: 97px;
	top: 20px;
	font-family: 'Bagel Fat One';
	font-style: normal;
	font-weight: 400;
	font-size: 35px;
	line-height: 51px;
	/* identical to box height */
	display: flex;
	align-items: center;
	text-align: center;
	color: #FFFFFF;
}




.admin {
	position: absolute;
	width: 74px;
	height: 38px;
	left: 1606px;
	top: 31px;
	font-family: 'Jua';
	font-style: normal;
	font-weight: 400;
	font-size: 30px;
	line-height: 38px;
	/* identical to box height */
	display: flex;
	align-items: center;
	text-align: center;
	color: #FFFFFF;
}

.user {
	position: absolute;
	width: 74px;
	height: 38px;
	left: 1750px;
	top: 31px;
	font-family: 'Jua';
	font-style: normal;
	font-weight: 400;
	font-size: 30px;
	line-height: 38px;
	/* identical to box height */
	display: flex;
	align-items: center;
	text-align: center;
	color: #FFFFFF;
}
</style> -->

    
</head>

<body>
	<c:set var="path"
		value="${pageContext.request.servletContext.contextPath}" />
	<nav class="topmenu">
		<ul class="nav">
			<li><img src="static/image/logo.png" alt="logo" class="logo"></li>
			<li><a href="" class="main"> 공연예매 </a></li>
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
				<td><a href="${path}/boardDetail.do?bno=${show.id}"><img
						src="" alt="show image"></a></td>
				<td>${show.performer}</td>
				<td>${show.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>