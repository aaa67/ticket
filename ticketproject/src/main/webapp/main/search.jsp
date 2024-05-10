<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&family=Nanum+Gothic&display=swap"
	rel="stylesheet">

	<table>
		<c:forEach var="show" items="${searchList}">
			<tr>
				<td><a href="${path}/showList"><img src="" alt="show image"></a></td>
				<td>${show.performer}<br>${show.name}</td>
			</tr>
		</c:forEach>
	</table>