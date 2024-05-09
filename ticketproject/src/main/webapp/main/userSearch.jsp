<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table border="1">
	<c:forEach var="show" items="${searchList}">
		<tr>
			<td><a href="${path}/showList"><img src="" alt="show image"></a></td>
			<td>${show.performer}</td>
			<td>${show.name}</td>
			<c:if test="${show.status eq '예매 가능'}">
				<td><a href="${path}/member/ticket?id=${show.id}"><button
							type="button">예매</button></a></td>
			</c:if>
			<c:if test="${show.status eq '매진'}">
				<td><button type="button">매진</button></td>
			</c:if>
		</tr>
	</c:forEach>
</table>