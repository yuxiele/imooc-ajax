package com.lee;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@CrossOrigin(origins = "http://localhost:8082", maxAge = 3600, allowCredentials = "true") 
public class TestController {
	
	@GetMapping("/get01")
	private ResultBean get01() {
		System.out.println("TestController.get01()");
		return new ResultBean("get01 ok");
	}
	
	//@RequestBody自动把json数据组装成对象
	@PostMapping("/postJson")
	public ResultBean postJson(@RequestBody User user) {
		System.out.println("TestController.postJson()");
		return new ResultBean("postJson " + user.getName());
	}
	
	//@CookieValue获取cookie值
	@GetMapping("/getCookie")
	public ResultBean getCookie(@CookieValue(value="cookie01") String cookie01) {
		System.out.println("TestController.getCookie()");
		return new ResultBean("getCookie " + cookie01);
	}
	
	//@RequestHeader获取请求头
	@GetMapping("/getHeader")
	public ResultBean getHeader(@RequestHeader("x-header1") String header1,
			@RequestHeader("x-header2") String header2) {
		System.out.println("TestController.getHeader()");
		return new ResultBean("getHeader " + header1 + " " + header2);
	}
	
}
