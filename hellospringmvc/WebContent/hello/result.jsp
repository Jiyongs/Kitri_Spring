<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이 프로젝트는 모든 jsp파일을 hello폴더 안에 지정한다고 가정! => /hello/xxxx.jsp가 될 것임 -->
<!-- dispatcher-servlet.xml에서 '/hello/' 와 '.jsp'를 접두어 & 접미어로 설정함 -->
<!-- 
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/hello/"></property>
		<property name="suffix" value=".jsp"></property>
</bean>
 -->
 
 <div align="center">
 결과 : ${msg}
 </div>
</body>
</html>
