package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.IrtalkDao;
import com.stx.dao.rtalkDao;
import com.stx.entity.ShowUserRTalk;

/**
 * Servlet implementation class UserAllRTalkServlet
 */
@WebServlet("/userallrtalk")
public class UserAllRTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IrtalkDao talk = new rtalkDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAllRTalkServlet() {
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
		ArrayList<ShowUserRTalk> list = talk.getUserRTalk(userid);
		String json = new Gson().toJson(list);
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
