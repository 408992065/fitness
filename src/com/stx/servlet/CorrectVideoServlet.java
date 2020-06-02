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
import com.stx.dao.CorrectDao;
import com.stx.dao.ICorrectDao;
import com.stx.entity.AllCorrect;

/**
 * Servlet implementation class CorrectVideoServlet
 */
@WebServlet("/correctvideo")
public class CorrectVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICorrectDao dao = new CorrectDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CorrectVideoServlet() {
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
		int status=Integer.parseInt(request.getParameter("status"));
		ArrayList<AllCorrect> list = dao.getAllGuidance(userid,status);
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
