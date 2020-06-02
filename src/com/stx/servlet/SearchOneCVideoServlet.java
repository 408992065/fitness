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
import com.stx.dao.ICvideoDao;
import com.stx.dao.cvideoDao;
import com.stx.entity.cvideo;

/**
 * Servlet implementation class SearchOneCVideoServlet
 */
@WebServlet("/searchonecvideo")
public class SearchOneCVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICvideoDao cd = new cvideoDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchOneCVideoServlet() {
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
		cvideo cvideo = cd.getOneCVideo(cvideoid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cvideo", cvideo);
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
