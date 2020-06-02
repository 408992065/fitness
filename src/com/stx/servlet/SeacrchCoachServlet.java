package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.CoachDao;
import com.stx.dao.ICoachDao;
import com.stx.entity.ShowCoach;


/**
 * Servlet implementation class SeacrchCoachServlet
 */
@WebServlet("/searchcoach")
public class SeacrchCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICoachDao cd = new CoachDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SeacrchCoachServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int coachid = Integer.parseInt(request.getParameter("coachid"));
		ShowCoach coach = cd.getCoach(coachid);
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("coach", coach);
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
