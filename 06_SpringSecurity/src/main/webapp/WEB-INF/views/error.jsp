<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- jstl 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>접근제한</h1>
	<!-- 403 오류명 기입해서 여기 페이지 보여지게 함-->
	<p><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></p>
</body>
</html>