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
	
	<!-- 
		CSRF (Cross-site request forgery, 사이트간 요청 위조)
		: 요청을 일부러 위조를 시켜서 공격을 한다(낚이는 광고들! : 축하드립니다 고갱뉨~) 토큰을 이용해서 방지
		방지하기 위해서 로그인을 하기위해서는 입력을 해줘야한당.
		- 스프링 시큐리티에서 CSRF 토큰을 이용하게 되면 '사이트간 위조 방지' 목적으로 사용하는 방식
		- CSRF 토큰 : 사용자가 임의로 변하는 특정한 토큰값을 서버에서 체크하는 방식
	 -->
	<!-- action이 login 이야지 security에서 처리 해준다. 무조건 name을 username으로 해줘야함-->
	<form action="login" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		아이디 : <input type="text" name="username"><br>
		비밀번호 : <input type="password" name="password"><br>
		<input type="submit" value="로그인"/>
	</form>
</body>
</html>