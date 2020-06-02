package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.WeChatService;

/**
 * Servlet implementation class GetSessionServlet
 */
@WebServlet("/getsession")
public class GetSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetSessionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 转成json数据
		String appid = request.getParameter("appid");
		String secret = request.getParameter("appsecret");
		String js_code = request.getParameter("code");
		WeChatService getOpenId = new WeChatService();
		String openId = getOpenId.GetOpenID(appid, secret, js_code);
		Map<String, String> result = new HashMap<String, String>();
		result.put("openId", openId);
		result.put("msg", "后台已收到");
		String json = new Gson().toJson(result);
		// 返回值给微信小程序
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
