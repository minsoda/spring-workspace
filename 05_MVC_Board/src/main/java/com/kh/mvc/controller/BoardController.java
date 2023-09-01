package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*") // 이렇게 경로들이 같으면 작성 가능
public class BoardController {

	// 많이 사용되서 전역변수로 활용함
	String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";
	
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
	public String insert(Board board) throws IOException {

		fileUpload(board);
		service.insertBoard(board);
		return "redirect:/board/list";
	}
	
	//list.jsp에서 no가 넘어와서 vo로 넣었음.-> view로 넘어감
	@GetMapping("/view")
	public void view(int no, Model model) {
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	@GetMapping("/update")
	public void update(int no, Model model) {
	//정보 가지고 있어야하니까 model 넣어둠!
		model.addAttribute("vo", service.selectBoard(no));
	}
	
	// 파일 업로드 할 수 있는 메소드 만들어줌
	public void fileUpload(Board board) throws IOException {
		// 업로드가 되고 해당되는 URL로 가야함
		// 파일 업로드 기능 추가
	MultipartFile file = board.getUploadFile();
	System.out.println(file);
				
	if(!file.isEmpty()) { // 업로드한 파일이 있는 경우!
		
	// 기존에 파일이 있는 경우 삭제!
	if(board.getUrl()!= null) {
		// /upload/grid6.jpg 중에서 파일이름만 추출후 삭제!
		// 새로고침을 할경우, 기존에 있던 파일을 수정을 했던 이미지로 변경!  
		File delFile = new File(path + board.getUrl().replace("/upload/", ""));
		delFile.delete();
	}
	System.out.println("파일의 사이즈 : "  + file.getSize());
	System.out.println("업로드된 파일명 :  " + file.getOriginalFilename());
	System.out.println("파일의 파라미터명 : " + file.getName());
	
	// 중복 방지를 위한 UUID 적용
	UUID uuid = UUID.randomUUID();
	String filename = uuid.toString() + "_" + file.getOriginalFilename();
	
	File copyFile = new File(path + filename);
	file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 지정
	// 웹에서 파일 업로드하고 프로젝트 새로고침하면 rsources에 upload 폴더에 사진 저장됨.
					
	// 데이터베이스에 경로 저장(* 주의 : 톰캣의 server.xml에 추가해줘야함, mapper에도 추가해줘야함!)
	// path를 /upload로 해놔서 http://localhost:8080/upload/kiwi.jpg 이렇게 검색시 확인 가능
	board.setUrl("/upload/" + filename); // 오라클에서 확인 가능 : /upload/grid6.jpg
	}
				}
	
	@PostMapping("/update")// 리소스를 저장할때 사용
	public String update (Board board) throws IOException {
		
		//메소드 만들어서 던짐~
			fileUpload(board);
			service.updateBoard(board);
			return "redirect:/board/list";
	}
	
	@GetMapping("/delete") // 리소스를 조회할때 사용
	public String delete(int no) {
		Board board = service.selectBoard(no);
		
		if(board.getUrl()!= null) {
			// /upload/grid6.jpg 중에서 파일이름만 추출후 삭제!
			// 새로고침을 할경우, 기존에 있던 파일을 수정을 했던 이미지로 변경!  
			File delFile = new File(path + board.getUrl().replace("/upload/", ""));
			delFile.delete();
			}
		service.deleteBoard(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/download")
	public ModelAndView downloadFile(String filename) {
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView", map);
	}
	
}
