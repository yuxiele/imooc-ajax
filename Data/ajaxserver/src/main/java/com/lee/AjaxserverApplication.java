package com.lee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AjaxserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxserverApplication.class, args);
	}
	
	/*@Bean
	public FilterRegistrationBean registerFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.addUrlPatterns("/*"); //让所有请求都经过这个Filter
		bean.setFilter(new CrosFilter()); //设置Filter的实例
		return bean;
	}*/
	
}
