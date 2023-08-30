package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

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
	@GetMapping("/list")
	public void list(Model model) {
		List<Board> list = service.selectAllBoard();
		model.addAttribute("list", list);
		// return "board/list"; 위치 같아서 반환 안해됨!
	}
	// 이렇게도 있음!
//	@PostMapping("/list")
//	@PutMapping
//	@DeleteMapping
	
	
	@RequestMapping("/insert")
	public void insert() {
		
	}
}
