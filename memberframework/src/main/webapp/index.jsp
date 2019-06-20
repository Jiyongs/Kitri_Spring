<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h3>Spring & Mybatis를 이용한 회원관리</h3>
<a href="${root}/user/register.kitri">회원가입</a> <!-- act = .kitri -->
<a href="${root}/user/login.kitri">로그인</a>
</div>
</body>
</html>