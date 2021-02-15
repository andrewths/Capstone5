package com.example.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope("prototype")

	public User user() {
		User u = new User();
		return u;
	}


}
