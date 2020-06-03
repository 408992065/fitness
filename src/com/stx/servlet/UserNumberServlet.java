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
import com.stx.dao.IUserNumberDao;
import com.stx.dao.UserNumberDao;
import com.stx.entity.UserNumber;

/**
 * Servlet implementation class UserNumberServlet
 */
@WebServlet("/usernumber")
public class UserNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserNumberDao dao = new UserNumberDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserNumberServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		UserNumber number = dao.getAllNumber(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("number", number);
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
