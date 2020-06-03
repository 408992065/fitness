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
import com.stx.dao.IJtalkDao;
import com.stx.dao.JtalkDao;
import com.stx.entity.ShowJTalk;

/**
 * Servlet implementation class SearchJTalkServlet
 */
@WebServlet("/searchjtalk")
public class SearchJTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IJtalkDao dao = new JtalkDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchJTalkServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cvideoid = Integer.parseInt(request.getParameter("cvideoid"));
		ArrayList<ShowJTalk> jtalk = dao.getJtalk(cvideoid);
		String json = new Gson().toJson(jtalk);
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
