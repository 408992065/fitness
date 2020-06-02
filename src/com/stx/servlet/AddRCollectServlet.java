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
import com.stx.dao.IRCollectDao;
import com.stx.dao.RCollectDao;
import com.stx.entity.RCollect;

/**
 * Servlet implementation class AddRCollectServlet
 */
@WebServlet("/addrcollect")
public class AddRCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRCollectDao dao = new RCollectDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddRCollectServlet() {
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
		int recipesid = Integer.parseInt(request.getParameter("recipesid"));
		RCollect rc = new RCollect(recipesid, userid);
		if (dao.addRCOllect(rc)) {
			RCollectDao da = new RCollectDao();
			int rcollectid = da.existRCOllect(userid, recipesid);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("rcollectid", rcollectid);
			String json = new Gson().toJson(map);
			Writer out = response.getWriter();
			out.write(json);
			out.flush();
		}
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
