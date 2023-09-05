package com.kh.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.api.model.Person;

//버전 자바 11로 바꾸고! api 에서 제일 중요한건 controller
@RestController
@RequestMapping("/simple")
public class SimpleController {
	
	// / 아닌, /api로 진핸
	// http://localhost:8080/api/simple/hello
	// 주소 써줘야함. jsp 가ㅣ 아니라 return 해주는게 restcontroller
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful API!";
	}
	
	// 객체로도 보낼수있는 예제.
	// Jackson Databind » 2.14.2 pom.xml에 추가
	/* {
    "name": "이름이 바뀌어용 0",
    "message": "내용이 바뀌어용 0"
	},
	 */
	@GetMapping("/greet")
	public Person sayGreet() {
		return new Person("민소", "포스트맨 안녕");
	}
	
	@GetMapping("/allGreet")
	public List<Person> allGreet(){
		List<Person> list = new ArrayList();
		for(int i=0; i<5; i++) {
			Person p = new Person();
			p.setName("이름이 바뀌어용 " + i);
			p.setMessage("내용이 바뀌어용 " + i);
			list.add(p);
		}
		return list;
	}
	
	/* [{
    "name": "이름이 바뀌어용 0",
    "message": "내용이 바뀌어용 0"
	},]
	 */

	// key(키 + 값) + 값 ex: join 형식
	@GetMapping("/sendGreet")
	public Map<Integer, Person> sendGreet(){
		Map<Integer, Person> map = new HashMap();
		map.put(1, new Person("이름을 적어주세요", "메세지를 보내주세요"));
		return map;
	}
	
	/*
	 * {
    	"1": {
        "name": "이름을 적어주세요",
        "message": "메세지를 보내주세요"
    		}
		}
	 * */
}
