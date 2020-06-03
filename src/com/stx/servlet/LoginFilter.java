package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.stx.entity.Token;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		String url = req.getRequestURI();
		if(url.endsWith("/login")||url.endsWith("/getsession")||url.endsWith(".mp4")||url.endsWith(".jpg")||url.endsWith(".mp3")||url.endsWith(".png")) {
			chain.doFilter(request, response);
		}else if(Token.token.get(request.getParameter("token"))!=null) {
			chain.doFilter(request, response);
		}else {
			  Map<String, Object> result = new HashMap<String, Object>();
			  result.put("error", "1");
			  String json = new Gson().toJson(result);
		        Writer out = response.getWriter();
		        out.write(json);
		        out.flush();
		}
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
