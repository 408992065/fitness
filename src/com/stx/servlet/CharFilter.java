package com.stx.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharFilter
 */
@WebFilter("/*")
public class CharFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CharFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		/* 设置响应头允许ajax跨域访问 */
		HttpServletResponse res = (HttpServletResponse) response;
		res.setHeader("Access-Control-Allow-Origin", "*");
		/* 星号表示所有的异域请求都可以接受， */
		res.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
