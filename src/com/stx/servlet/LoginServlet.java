package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.stx.dao.IwxuserDao;
import com.stx.dao.wxuserDao;
import com.stx.entity.Token;
import com.stx.entity.wxuser;


/**
 * Servlet implementation class LoginServlet
 * 
 * @param <K>
 */
@WebServlet("/login")
public class LoginServlet<K> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IwxuserDao wd = new wxuserDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int exist =1;
		String openid = request.getParameter("openid");
		int userid=wd.existUser(openid);
		if(userid==0){
			String name = request.getParameter("nickName");
			int gender=Integer.parseInt(request.getParameter("gender"));
			String purl=request.getParameter("avatarUrl");
			wxuser cs= new wxuser(name,openid,gender,purl);
			if(wd.addwxuser(cs)) {
				userid=wd.existUser(openid);
				exist=0;
			}
		}
		String token = UUID.randomUUID() + "";
		Token.token.put(token, userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("token", token);
		map.put("userid", userid);
		map.put("exist",exist);
		String json = new Gson().toJson(map);
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
