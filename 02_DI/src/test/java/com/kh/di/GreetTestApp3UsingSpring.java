package com.kh.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class GreetTestApp3UsingSpring {

	public static void main(String[] args) {
		
		//greet.xml에 주입했으니까 사용하려면 BeanFactory 만들어야쥐~
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/greet.xml"));
				
//		Greet g1 = (Greet) factory.getBean("greet1");
//		g1.printMessage();
		// com.kh.di.Greet..Instance Create..
		// com.kh.di.Greet=>null
		 
		// 생성자 주입
//		Greet g2 = (Greet) factory.getBean("greet2");
//		g2.printMessage();
		// com.kh.di.Greet=>Hello Spring!
		
		// setter 주입
//		Greet g3 = (Greet) factory.getBean("greet3");
//		g3.printMessage();
		// com.kh.di.Greet..Instance Create..
		// com.kh.di.Greet=>Hi Spring DI!!
	
	Greet g4 = (Greet) factory.getBean("greet4");
	g4.printMessage();
	// com.kh.di.Greet..Instance Create..
	// com.kh.di.Greet => Spring Bean~
	
	}
}
