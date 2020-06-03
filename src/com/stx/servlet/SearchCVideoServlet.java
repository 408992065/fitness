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
import com.stx.dao.ICvideoDao;
import com.stx.dao.cvideoDao;
import com.stx.entity.cvideo;

/**
 * Servlet implementation class SearchCVideoServlet
 */
@WebServlet("/searchcvideo")
public class SearchCVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  ICvideoDao cd = new cvideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int coachid = Integer.parseInt(request.getParameter("coachid"));
		ArrayList<cvideo> list = cd.getcvideo(coachid);
		String json = new Gson().toJson(list);
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
