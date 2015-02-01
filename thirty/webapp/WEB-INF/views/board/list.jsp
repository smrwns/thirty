<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 검색 -->
<form id="search_form" name="search_form" action="list" method="get">
	<input type="hidden" name="o_field" value="${searchContext.o_field }"/>
	<input type="hidden" name="o_direction" value="${searchContext.o_direction }"/>
	
	<select name="p_rowsize">
		<option value="5" <c:if test="${searchContext.p_rowsize eq 5}">selected="selected"</c:if>>5줄</option>
		<option value="10"<c:if test="${searchContext.p_rowsize eq 10}">selected="selected"</c:if>>10줄</option>
		<option value="20"<c:if test="${searchContext.p_rowsize eq 20}">selected="selected"</c:if>>20줄</option>
		<option value="30"<c:if test="${searchContext.p_rowsize eq 30}">selected="selected"</c:if>>30줄</option>
		<option value="50"<c:if test="${searchContext.p_rowsize eq 50}">selected="selected"</c:if>>50줄</option>
	</select>
	<select name="s_search_type">
		<option value="">전체</option>
		<option value="title" <c:if test="${searchContext.s_search_type eq 'title'}">selected="selected"</c:if>>제목</option>
		<option value="desc" <c:if test="${searchContext.s_search_type eq 'desc'}">selected="selected"</c:if>>내용</option>
	</select>
	<input type="text" name="s_keyword" value="${searchContext.s_keyword}" />
	
	<input type="button" value="검색" onclick="" />
</form>


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
