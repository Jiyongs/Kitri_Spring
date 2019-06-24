<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/commons/template/top.jsp" %>		<!-- *** -->
<style>
.menulist { width: 220px;}
.category {
	padding: 5px 10px;
	cursor: pointer;
	position: relative;
	font-weight: bold;
	text-align: left;
	background-color: rgb(205,211,252);
}

.menu {
	display: none;
	text-align: left;
}

.menu a {
	display: block;
	color: #000066;
	background-color: lightgray;
	padding: 10px;
	text-decoration: none;
}

.menu a:hover{
	color: #000000;
	text-decoration: underline;
}
</style>

<script>
$(document).ready(function() {
	$("#boardmenu p.category").click(function() {
		$(this).next("div.menu").slideDown(500).siblings("div.menu").slideUp("slow");	/* 카테고리 클릭 시, 서브 메뉴 내리기 */
	});
});

</script>

<div class="menulist" id="boardmenu">
	<c:set var="idx" value="0"/>
	
	<!-- 카페 메뉴 출력 -->
	<c:forEach varStatus="i" var="board" items="${boardmenu}">
		<!-- 카테고리 중복 제거하여 출력 -->
		<c:if test="${idx != board.ccode}">
			<p class="category">${board.cname}</p>
			<c:set var="idx" value="${board.ccode}"/>
			
			<!-- 게시판 이름 출력 -->
			<div class="menu">
		</c:if>
		
		<a href="${root}/${board.control}/write?bcode=${board.bcode}&pg=1&key=&word=">
			${board.bname}
		</a>
		<!-- 현재 index가 boardmenu의 마지막 index보다 작을 때 -->
		<c:if test="${i.index < boardmenu.size() - 1}">
			<!-- 현재 idx와 다음번 ccode가 다를때 -->
			<c:if test="${idx != boardmenu.get(i.index+1).ccode}">
			</div>		
		</c:if>
		</c:if>
	</c:forEach>
	</div> <!-- 마지막 size의 div 닫기 -->
	
</div>

<%@ include file="/WEB-INF/views/commons/template/bottom.jsp" %>	<!-- *** -->
