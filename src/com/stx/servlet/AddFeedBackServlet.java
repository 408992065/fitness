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
import com.stx.dao.FeedBackDao;
import com.stx.dao.IFeedBackDao;
import com.stx.entity.FeedBack;

/**
 * Servlet implementation class AddFeedBackServlet
 */
@WebServlet("/addfeedback")
public class AddFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFeedBackDao fd=new FeedBackDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddFeedBackServlet() {
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
		String content = request.getParameter("content");
		FeedBack fb = new FeedBack(userid, content);
		if (fd.addFeedback(fb)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", 1);
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
