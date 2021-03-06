<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="board" tagdir="/WEB-INF/tags/board/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 검색 -->
<form id="searchForm" name="searchForm" action="/board/list" method="get">
	<input type="hidden" name="orderField" value="${searchContext.orderField }"/>
	<input type="hidden" name="orderDirection" value="${searchContext.orderDirection }"/>
	<input type="hidden" name="numPage" value="${searchContext.numPage}" />
	
	<select name="rowCountPerPage">
		<option value="5" <c:if test="${searchContext.rowCountPerPage eq 5 }">selected="selected"</c:if>>5줄</option>
		<option value="10"<c:if test="${searchContext.rowCountPerPage eq 10}">selected="selected"</c:if>>10줄</option>
		<option value="20"<c:if test="${searchContext.rowCountPerPage eq 20}">selected="selected"</c:if>>20줄</option>
		<option value="30"<c:if test="${searchContext.rowCountPerPage eq 30}">selected="selected"</c:if>>30줄</option>
		<option value="50"<c:if test="${searchContext.rowCountPerPage eq 50}">selected="selected"</c:if>>50줄</option>
	</select>
	<select name="searchType">
		<option value="">전체</option>
		<option value="title" <c:if test="${searchContext.searchType eq 'title'}">selected="selected"</c:if>>제목</option>
		<option value="desc" <c:if test="${searchContext.searchType eq 'desc'}">selected="selected"</c:if>>내용</option>
	</select>
	<input type="text" name="searchKeyword" value="${searchContext.searchKeyword}" />
	<input type="button" value="검색" onclick="PagingManager.goFirstPage();"/>
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
				<td><a href="${board.id}/view?${searchContext.allParam}">${board.title}</a></td>
				<td>${board.desc}</td>
				<td><fmt:formatDate value="${board.create_dt}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이징 -->
<board:paging searchContext="${searchContext}"/>

<!-- 등록 -->