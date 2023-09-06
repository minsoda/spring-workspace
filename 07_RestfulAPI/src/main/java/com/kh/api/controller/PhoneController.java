package com.kh.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Phone;
import com.kh.api.service.PhoneService;

@RestController
public class PhoneController {
	
	// interface로 주입가능
	@Autowired
	private PhoneService service;
	
	// http://localhost:8080/api/phone
	@GetMapping("/phone")
	public ResponseEntity select() {
		// phone 전체 리스트 작성
		try {
			
			List<Phone> list = service.select();
			return new ResponseEntity(list, HttpStatus.OK); // 데이터와 상태코드도 같이 보낼수있는 장점!ex)ok : 200
			
		}catch(RuntimeException e) {
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/phone/{num}")
	public ResponseEntity select(@PathVariable String num) {
		try {
			Phone phone = service.select(num);
			return new ResponseEntity(phone, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(service.select(num), HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/phone") // body-row-json으로 
	public ResponseEntity insert(@RequestBody Phone phone) {
		try {
			int result = service.insert(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping("/phone")
	public ResponseEntity update(@RequestBody Phone phone) {
		
		try {
			int result = service.update(phone);
			return new ResponseEntity(result, HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/phone/{num}")
	public ResponseEntity delete(@PathVariable String num) {
		
		try {
			service.delete(num);
			return new ResponseEntity(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

}
