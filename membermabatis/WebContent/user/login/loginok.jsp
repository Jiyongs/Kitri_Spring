<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/template/header.jsp" %>

<c:if test="${userInfo != null}">

<script type="text/javascript">
function deleteMember() {
	if(confirm("정말 탈퇴하시겠습니까?")){
		document.location.href = "${root}/user?act=deleteMember";
		// 나중에 만들기 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	}
}
</script>

<strong>${userInfo.name}(${userInfo.id})님 안녕하세요.</strong>
<a href="${root}/user?act=logout">로그아웃</a>
<a href="${root}/user?act=mvmodify">정보수정</a>
<a href="#" onclick="javascript:deleteMember();">회원탈퇴</a>

	<c:if test="${'shzy232' == userInfo.id}">
			<a href="${root}/admin?act=memberlist">관리자</a>
	</c:if>
</c:if>

<c:if test="${userInfo == null}">
	<c:redirect url="/user?act=mvlogin"/>
</c:if>

<%@ include file = "/template/footer.jsp" %>