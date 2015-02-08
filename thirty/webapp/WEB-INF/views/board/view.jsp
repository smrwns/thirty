<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ taglib prefix="board" tagdir="/WEB-INF/tags/board/" %> --%>

<table>
	<tbody>
		<tr>
			<th>id</th>
			<td>${board.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.desc}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${board.create_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
	</tbody>
</table>

<a href="../list?${searchContext.allParam}">목록</a>
<!-- 수정 -->