package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*") // 이렇게 경로들이 같으면 작성 가능
public class BoardController {

	@Autowired
	private BoardService service;

//	@RequestMapping("board/list")
//	public ModelAndView list() {
//		List<Board> list = service.selectAllBoard();
//		// (경로, 바인딩 변수, 바인딩할 객체)
//		return new ModelAndView("board/list", "list", list);
//	}
	// 이런 뜻이 숨어있당! @RequestMapping(value="/list", method=RequestMethod.GET)
	// return "board/list"; 위치 같아서 반환 안해됨!
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<Board> list = service.selectAllBoard(cri);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}
	// 이렇게도 있음!
//	@PostMapping("/list")
//	@PutMapping
//	@DeleteMapping
	
	
	@GetMapping("/insert")
	public void insert() {
		
	}
	
	@PostMapping("/insert")
	public String insert(Board board) {
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	//list.jsp에서 no가 넘어와서 vo로 넣었음.-> view로 넘어감
	@GetMapping("/view")
	public void view(int no, Model model) {
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	@PostMapping("/update")// 리소스를 저장할때 사용
	public String update (Board board) {
		service.updateBoard(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete") // 리소스를 조회할때 사용
	public String delete(int no) {
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
}
