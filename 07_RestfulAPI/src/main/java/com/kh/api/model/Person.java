package com.kh.api.model;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * REST (Representational State Transfer)
 * - 하나의 URI는 하나의 고유한 리소스(Resource)를 대표하도록 설계하는 전송방식
 * - 가장 기억해야할 점은 서버에서 데이터 자체를 전송하는 방식으로 처리한다는 것 
 * 
 * API (Application Programming Interface)
 * - 컴퓨터와 컴퓨터 사이의 상호작용을 위한 연결방식
 * 
 * @RestController
 * - Controller가 REST 방식을 처리하기 위한 것임을 명시
 * - 메서드의 리턴 타입으로 사용자가 정의한 클래스 타입도 사용할 수 있고,
 * 이 외에도 여러 타입으로 보내는데 이를 JSON 이나 XML로 자동 처리
 * 
 * JSON (Java Script Object Notation)
 * - 데이터를 {중괄호}로 묶어서 키와 값으로 구성하는 데어터 포맷
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String name;
	private String message;
}
