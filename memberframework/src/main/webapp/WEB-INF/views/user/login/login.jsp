<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 프로젝트 안에 있는 파일을 기준으로 가져오기 때문에, memberjsp라는 프로젝트 이름은 작성하지 않아도 됨!!! -->
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<!-- 쿠키 얻어오기 -->
<%
	Cookie cookie[] = request.getCookies();
	
	// 저장된 id값 저장 변수
	String svid = "";
	// '아이디 저장' 체크박스 체크 여부 저장 변수
	String ckid = "";
	
	// 쿠키가 비어있지 않을 경우
	if(cookie != null) {
		for(Cookie c : cookie) {
			// 쿠키들 중, 이름이 "kid_inf"인 쿠키의 값을 얻어옴
			if("kid_inf".equals(c.getName())){
				svid = c.getValue();
				ckid = "checked";
				break;
			}
		}
	}
%>

<script type="text/javascript">
$(document).ready(function() {

	$("#loginBtn").click(function(){
		if($("#id").val().trim().length == 0) {
			alert("아이디를 입력해주세요!");
			return;
		} else if($("#pass").val().trim().length == 0) {
			alert("비밀번호를 입력해주세요!");		
			return;
		} else {
			$("#loginform").attr("action", "${root}/user/login.kitri").submit();
		}
	});
	
	$("#moveRegisterBtn").click(function(){
		$(location).attr("href", "${root}/user/register.kitri");
	});
	
});


</script>

<body>

<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>로그인</h2>
		<form id="loginform" method="post" action="">
			<div class="form-group" align="right">
				<label for=""><input type="checkbox" class="form-control" name="idsave" value="idsave" <%=ckid%>>아이디 저장</label>
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="id" name="id" value="<%=svid%>" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="pass" name="pass" placeholder="">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" id="loginBtn">로그인</button>
				<button type="button" class="btn btn-primary" id="moveRegisterBtn">회원가입</button>
			</div>
		</form>
	</div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>