package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloTestApp3UsingSpring {

	public static void main(String[] args) {
		// 1. BeanFactory 생성.. 주문서 : 공장에서 미리 받아서 읽기
		System.out.println("1. BeanFactory 생성..");
		// Bean Configuration File : 빈(Bean) 설정 문서 만들고 오세용!
		// spring에 전부 있음
		BeanFactory factory =  new XmlBeanFactory(new FileSystemResource("src/main/resources/config/hello.xml"));
		
		// 2. getBean()으로 빈을 받아와서 printMessage() 호출
		// id로 지정한 hello을 보낸당!
		System.out.println("2. getBean() 클라이언트 호출..");
		Hello hello = (Hello) factory.getBean("hello");
		
	
	}
}
