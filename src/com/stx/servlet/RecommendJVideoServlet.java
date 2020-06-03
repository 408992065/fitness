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
import com.stx.dao.IRecommendJVideoDao;
import com.stx.dao.RecommendJVideoDao;
import com.stx.entity.RecommendJVideo;

/**
 * Servlet implementation class RecommendJVideoServlet
 */
@WebServlet("/recommendjvideo")
public class RecommendJVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRecommendJVideoDao rc = new RecommendJVideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendJVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int current =Integer.parseInt(request.getParameter("current"));
		int number =Integer.parseInt(request.getParameter("number"));
		ArrayList<RecommendJVideo> list = rc.recommendJVideo(current,number);
		String json=new Gson().toJson(list);
		Writer out = response.getWriter();
		out.write(json);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
