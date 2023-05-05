package com.SpringTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/success")
	@ResponseBody
	public String welcome() {
		return "Welcome";
	}
	
	@RequestMapping("/loginpage")
	public String loginpage() {
		return "loginpage";
	}
	
	@RequestMapping("/fail")
	@ResponseBody
	public String fail() {
		return "fail";
	}

}
