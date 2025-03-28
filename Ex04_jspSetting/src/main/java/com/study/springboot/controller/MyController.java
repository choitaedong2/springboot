package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "jsp 실행";
	}
	
	@RequestMapping("/test1") // url => localhost:8000/test1
	public String test1() { // String => 파일명
		return "test1"; // /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2") // url => localhost:8000/test2
	public String anyname() {
		return "sub/test2"; // 호출할 페이지 : /WEB-INF/views/sub/test2.jsp
	}
}
