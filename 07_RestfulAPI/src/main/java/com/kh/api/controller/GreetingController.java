package com.kh.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Greeting;

@RestController
public class GreetingController {

	// http://localhost:8080/api/greet --> selectList로 보여주기 (파라미터 경로에 포함)
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	
	// http://localhost:8080/board/view?no=123  (x)
	// - > http://localhost:8080/board/23 --> selectOne으로 왔을때 보여주기 (파라미터 경로에 포함)
	// no을 id로 보내봅시당~
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id) {
		// @PathVariable : URL 경로의 일부를 파라미터로 사용할 때 
		return "Hello REST API case number.." + id;
	}
	// http://localhost:8080/api/greet/13
	
	
	// http://localhost:8080/search?keyword=키워드
	// 파라미터 값을 받아와서 전달
	@GetMapping("/greet2")
	public Greeting sayGreet2(String content) {
		return new Greeting(500L, content);
	}
	/*
	 * {
    	"id": 500,
    	"content": "오모 이게모람?"
		}
	 * */
}
