package com.kh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.security.model.service.MemberService;
import com.kh.security.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	// bean 등록후 주입
	@Autowired
	private BCryptPasswordEncoder bcpe;
	
	// 권한 상관없이 전체 볼수있는 페이지 
	@GetMapping("/all")
	public void all() {}
	
	// 로그인후 볼수 있는 페이지
	@GetMapping("/member")
	public void member() {}
	
	//관리자만 들어올수있는 페이지 
	@GetMapping("/admin")
	public void admin() {}
	
	@GetMapping("/login")
	public void login() {}
	
	// 수동으로 로그인으로 해놨기때문에 logout도 수동으로 처리해줘야한다.
	@GetMapping("/logout")
	public void logout() {}
	
	// 에러 지정 페이지 위해서
	@GetMapping("/error")
	public void error() {}
	
	// 비밀번호 암호화처리하는건 controller와 service 둘중 하나에서 처리하면 됨
	@GetMapping("/register")
	public void register() {}
		
	// mapper에서 jsp로 넘어가서 post 방식으로 controller로 넘어옴.
	@PostMapping("/register")
	public String register(Member vo) {
		
		// 우리가 입력한 password 확인
		System.out.println("before password : " + vo.getPassword());
		
		// BcryptPasswordEncoder를 이요행서 암호화 처리
		// 우리가 입력한 password를 통해 암호화 처리를 함
		String encodePassword = bcpe.encode(vo.getPassword());
		System.out.println("after password : " + encodePassword);
		
		// 암호화된 password로 바꿔서 들어가야하니까
		vo.setPassword(encodePassword);
		
		
		service.registerMember(vo);
		return "redirect:/login";
	
	}
}
