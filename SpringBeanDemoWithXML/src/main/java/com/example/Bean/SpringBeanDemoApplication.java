package com.example.Bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class SpringBeanDemoApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context =
	            new ClassPathXmlApplicationContext("Beans.xml");

		User objA = (User) context.getBean("user");
	      objA.setSkill("I'm a Programmer");
	      objA.getSkill();
	      System.out.println(objA);
	      
	 
	      User objB = (User) context.getBean("user");
	      objB.setSkill("I'm a Developer");
	      objB.getSkill();
	      System.out.println(objB);
	      
	      context.close();
	}

}
