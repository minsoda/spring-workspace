package com.kh.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// 로그인 성공했을시에! 각각의 보여질 페이지 지정하는곳
// spring에 있는 AuthenticationSuccessHandler 참고!

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleList = new ArrayList();
		
		// 임의로 지정
		// 사용자의 정보를 가져오는 메소드
		authentication.getAuthorities().forEach(auth -> {
			System.out.println("auth : " + auth); // auth : ROLE_*** 권한 자체를 가져온다
			
			roleList.add(auth.getAuthority());

		});
		
		if(roleList.contains("ROLE_MEMBER")) {
			// member페이지 보일것이여!
			response.sendRedirect("/member");
			return;
		}
		
		if(roleList.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		}
		
		// 둘다 아닐경우는 all 페이지 보이기
		response.sendRedirect("/all");
	}

}
