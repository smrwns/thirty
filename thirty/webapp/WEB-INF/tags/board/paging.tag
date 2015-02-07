<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="searchContext" required="true" type="java.lang.Object" %>

<c:set var="numPage" value="${searchContext.numPage}" />
<c:set var="rowCountPerPage" value="${searchContext.rowCountPerPage}" />
<c:set var="pageCountPerPage" value="${searchContext.pageCountPerPage}" />
<c:set var="totalRowCount" value="${searchContext.totalRowCount}" />

<c:set var="startPage" value="${numPage - (numPage - 1) % pageCountPerPage}" />
<c:set var="endPage" value="${startPage + pageCountPerPage - 1}" />
<fmt:parseNumber var="lastPage" value="${totalRowCount / rowCountPerPage}" integerOnly="true" />

<c:if test="${totalRowCount % rowCountPerPage != 0}">
	<c:set var="lastPage" value="${lastPage +1 }"/>
</c:if>
<c:if test="${endPage > lastPage}">
	<c:set var="endPage" value="${lastPage}" />
</c:if>

<div class="pagingwrap">
	<div class="paging">
		<div>
			<c:if test="${startPage != 1 }">
				<a href="#" onclick="PagingManager.goSpot(1);return false;">《</a>
			</c:if>
			<c:if test="${numPage-1 >= pageCountPerPage}">
				<a href="#" onclick="PagingManager.goSpot(${startPage-1});return false;">〈</a>
			</c:if>
			<c:forEach begin="${startPage}" end="${endPage}" step="1" varStatus="status" var="i">
				<c:choose>
					<c:when test="${i == numPage}"><b>${i}</b></c:when>
					<c:otherwise><a href="#" onclick="PagingManager.goSpot(${i});return false;">${i}</a></c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${startPage + pageCountPerPage <= lastPage}">
				<a href="#" onclick="PagingManager.goSpot(${endPage + 1});return false;">〉</a>
			</c:if>
			<c:if test="${endPage < lastPage}">
				<a href="#" onclick="PagingManager.goSpot(${lastPage});return false;">》</a>
			</c:if>
		</div>
	</div>
</div>

<script type="text/javascript">
var totalRowCount = ${totalRowCount};
var PagingManager = {
		searchForm : document.searchForm,
		
		goSpot : function(numPage) {
			this.searchForm.numPage.value = numPage;
			this.searchForm.submit();
		},
		
		goFirstPage : function() {
			var firstPage = 1;
			this.searchForm.numPage.value = firstPage;
			this.searchForm.submit();
		},
		
		goLastPage : function() {
			try {
				var lastPage = Math.ceil(totalRowcount/this.searchForm.rowCountPerPage);
				this.searchForm.numPage.value = lastPage; 
			} catch(e) {
				this.searchForm.numPage.value = ${searchContext.totalPageCount};
			}
			this.searchForm.submit();
		},
		
		order : function(orderField) {
		}
};
</script>