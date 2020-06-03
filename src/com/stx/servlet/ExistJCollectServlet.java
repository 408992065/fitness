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
import com.stx.dao.IJCollectDao;
import com.stx.dao.JCollectDao;

/**
 * Servlet implementation class ExistJCollectServlet
 */
@WebServlet("/existjcollect")
public class ExistJCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IJCollectDao dao = new JCollectDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExistJCollectServlet() {
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
		int cvideoid = Integer.parseInt(request.getParameter("cvideoid"));
		int jcollectid = dao.existJCollect(userid, cvideoid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("jcollectid", jcollectid);
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
