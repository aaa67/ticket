<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path"
	value="${pageContext.request.servletContext.contextPath}" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Jua&family=Nanum+Gothic&display=swap"
	rel="stylesheet">

	<table>
		<c:forEach var="show" items="${searchList}">
			<tr>
				<td width=300 height=100 style='table-layout:fixed'><a href="${path}/detail?id=${show.id}"><img src="${path}/upload/${show.image}" alt="image"></a></td>
				<td width=300 height=100 style='word-break:break-all;' class="content"><a href="${path}/detail?id=${show.id}">${show.performer}<br><br>${show.name}</a></td>
			</tr>
		</c:forEach>
	</table>