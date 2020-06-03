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
import com.stx.dao.CoachDao;
import com.stx.dao.ICoachDao;
import com.stx.entity.ShowCoach;
import com.stx.entity.coach;

/**
 * Servlet implementation class UserSearchCoachServlet
 */
@WebServlet("/usersearchcoach")
public class UserSearchCoachServlet extends HttpServlet {
	 static final long serialVersionUID = 1L;
	 private ICoachDao dao = new CoachDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSearchCoachServlet() {
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
		int gender = Integer.parseInt(request.getParameter("gender"));
		String name = request.getParameter("name");
		coach ch = new coach(coachid, name, gender);
		ArrayList<ShowCoach> list = dao.searchCoach(ch);
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
