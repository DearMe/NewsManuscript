package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("\\WEB-INF\\applicationContext.xml");
		TestService testService = (TestService)ac.getBean("testService");
		System.out.println(testService.getName());
	}

}
