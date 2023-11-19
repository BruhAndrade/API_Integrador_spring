package com.gamma.apigames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/go")
	public String helloworld() {
		return "Hello World";
	}
}
