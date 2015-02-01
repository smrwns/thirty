<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 검색 -->

<!-- 리스트 -->
<table>
	<thead>
		<tr>
			<th>key</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.desc}</td>
				<td><fmt:formatDate value="${board.create_dt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</tbody>
	
<!-- 페이징 -->

<!-- 등록 -->
</table>
