<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>

	<form action="/login" method="post">
	<!-- 로그인은 무조건 name : username -->
		아이디 : <input type="text" name="username"><br>
		비밀번호 : <input type="password" name="password"><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>