<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="searchContext" required="true" type="java.lang.Object" %>

<c:set var="page" value="${searchContext.page}" />
<c:set var="rowCountPerPage" value="${searchContext.rowCountPerPage}" />
<c:set var="pageCountPerPage" value="${searchContext.pageCountPerPage}" />
<c:set var="totalRowCount" value="${searchContext.totalRowCount}" />

<c:set var="start_page" value="${page - (page - 1) % pageCountPerPage}" />
<c:set var="end_page" value="${start_page + pageCountPerPage - 1}" />
<fmt:parseNumber var="last_page" value="${totalRowCount / rowCountPerPage}" integerOnly="true" />

<c:if test="${totalRowCount % rowCountPerPage != 0}">
	<c:set var="last_page" value="${last_page +1 }"/>
</c:if>
<c:if test="${end_page > last_page}">
	<c:set var="end_page" value="${last_page}" />
</c:if>

<div class="pagingwrap">
	<div class="paging">
		<div>
			<c:if test="${start_page != 1 }">
				<a href="#" onclick="PagingManager.goSpot(1);return false;">《</a>
			</c:if>
			<c:if test="${page-1 >= pageCountPerPage}">
				<a href="#" onclick="PagingManager.goSpot(${start_page-1});return false;">〈</a>
			</c:if>
			<c:forEach begin="${start_page}" end="${end_page}" step="1" varStatus="status" var="i">
				<c:choose>
					<c:when test="${i == page}"><b>${i}</b></c:when>
					<c:otherwise><a href="#" onclick="PagingManager.goSpot(${i});return false;">${i}</a></c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${start_page + pageCountPerPage <= last_page}">
				<a href="#" onclick="PagingManager.goSpot(${end_page + 1});return false;">〉</a>
			</c:if>
			<c:if test="${end_page < last_page}">
				<a href="#" onclick="PagingManager.goSpot(${last_page});return false;">》</a>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
var totalRowCount = ${totalRowCount};
var PagingManager = {
		searchForm : document.searchForm,
		
		goSpot : function(page) {
			this.searchForm.page.value = page;
			this.searchForm.submit();
		},
		
		goFirstPage : function() {
			var firstPage = 1;
			this.searchForm.page.value = firstPage;
			this.searchForm.submit();
		},
		
		goLastPage : function() {
			try {
				var lastPage = Math.ceil(totalRowcount/this.searchForm.rowCountPerPage);
				this.searchForm.page.value = lastPage; 
			} catch(e) {
				this.searchForm.page.value = ${searchContext.totalPageCount};
			}
			this.searchForm.submit();
		},
		
		order : function(field) {
		}
};
</script>