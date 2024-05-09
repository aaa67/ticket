<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table border="1">
		<c:forEach var="show" items="${searchList}">
			<tr>
				<td><a href="${path}/showList"><img src="" alt="show image"></a></td>
				<td>${show.performer}</td>
				<td>${show.name}</td>
			</tr>
		</c:forEach>
	</table>