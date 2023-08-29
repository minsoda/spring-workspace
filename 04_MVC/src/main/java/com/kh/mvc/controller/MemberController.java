package com.kh.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

// conponent에 해당됨. 핸들러 등은 web.xml과 servlet-context에 숨겨져 있음~
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("search")
	public String search() {
		// /WEB-INF/views/ ---  return "search"  --- .jsp 앞뒤로 붙어있어서 전달이 가능
		return "search";
	}
	
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		// 서비스 - 비즈니스 로직 처리!
		// -> list 값! 데이터 바인딩 -> Model!
		List<Member> list =  new MemberService().findMember(keyword);
		
		if(list != null) {
			model.addAttribute("list", list);
		}
		return "find_ok";// "find_fal"
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("signUp")
	public String signUp(Member member) {
		System.out.println(member);
		// 바인딩 없이 index.jsp로 넘길때 이렇게 사용!
		// 비즈니스 로직
		return "redirect:/";
	}
	
	// login - 페이지 이동
	@RequestMapping("login")
	public String login(Member member) {
		return "login";
	}
	
	// signIn - 비즈니스 로직 포함 : 파라미터 값
	// - > HttpServletRequest request
	// -> return "login_result"
	@RequestMapping("signIn")
	public String signIn(Member member) {
		new MemberService().login(member);
		
		return "login_result";
	}
	
	// allMember - 비즈니스 로직 포함, 데이터 바인딩 - Model
	// --> return "find_ok";
	@RequestMapping("allMember")
	public String allMember(Member member) {
		return "find_ok";
	}
	
	// logout - 로그아웃 기능!
	@RequestMapping("logout")
	public String logout(Member member) {
		return "logout";
	}
	
	// update - 페이지 이동
	@RequestMapping("update")
	public String update(Member member) {
		return "update";
	}
	
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	@RequestMapping("updateMember")
	public String updateMember(Member member, HttpServletRequest request) {
		new MemberService().updateMember(member);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", member);
		
		return "update_result";
	}
	
	
}
