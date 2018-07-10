package com.lee;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

public class CrosFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 在doFilter里面增加响应头，需要先把response强转一下
		HttpServletResponse res = (HttpServletResponse)response;
		
		/*
		 * 在doFilter里面获取请求头，需要先把request强转一下
		 * 获取request里面的origin参数的域名信息，用于写回到"Access-Control-Allow-Origin"里面，
		 * 解决因为带cookie的时候，Origin设置必须是全匹配，不能使用通配符*号，导致未被指定的域不能访问的问题。
		 */
		HttpServletRequest req = (HttpServletRequest)request;
		
		String origin = req.getHeader("Origin");
		if(!StringUtils.isEmpty(origin)) {
			//指定允许跨域的域名(带cookie的时候，Origin设置必须是全匹配，不能使用通配符*号)
			res.addHeader("Access-Control-Allow-Origin", origin);
		}
		
		//指定允许的请求方法
		res.addHeader("Access-Control-Allow-Methods", "*");
		
		String headers = req.getHeader("Access-Control-Request-Headers");
		// 支持所有自定义头
		if (!StringUtils.isEmpty(headers)) {
			res.addHeader("Access-Control-Allow-Headers", headers);			
		}
		
		//指定允许的请求头
		res.addHeader("Access-Control-Allow-Headers", "Content-Type,x-header1,x-header2");
		//指定预检缓存时间
		res.addHeader("Access-Control-Max-Age", "3600");
		//enable cookie（带cookie的跨域是需要设置该值的）
		res.addHeader("Access-Control-Allow-Credentials", "true");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
