package com.geekbang.spring.shadyDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShadyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShadyDemoApplication.class, args);
	}
	@RequestMapping("/hello")
	public  String hello(){
		return  "Hello Shady!";
	}

}
