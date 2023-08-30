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
	
	// request.setAttribute = Model로 함
	@RequestMapping("find")
	public String find(String keyword, Model model) {
		System.out.println(keyword);
		// 서비스 - 비즈니스 로직 처리!
		// -> list 값! 데이터 바인딩 -> Model!
		List<Member> list =  service.findMember(keyword);
		
		//list는 항상 있어서 size로 조건 걸어줌
		if(list.size() > 0) {
			model.addAttribute("list", list);
			return "find_ok";
		}
		return "find_fail";
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
		service.registerMember(member);
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
	public String signIn(Member vo, HttpSession session) {
		Member member = service.login(vo);

		if(member != null) {
			session.setAttribute("vo", member);
			
		}
		return "login_result";
	}
	
	// allMember - 비즈니스 로직 포함, 데이터 바인딩 - Model
	// --> return "find_ok";
	@RequestMapping("allMember")
	public String allMember(Model model) {
		List<Member> list = service.showAllMember();
		model.addAttribute("list", list);
		return "find_ok";
	}
	
	// logout - 로그아웃 기능!
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	// update - 페이지 이동
	@RequestMapping("update")
	public String update() {
		return "update";
	} 
	
	// updateMember - 비즈니스 로직 포함 -> 파라미터 request 필요
	@RequestMapping("updateMember")
	public String updateMember(Member vo, HttpSession session) {
		service.updateMember(vo);
		if(session.getAttribute("vo")!= null) {
			session.setAttribute("vo", vo);
		}
	
		return "redirect:/";
	}
	
	
}
