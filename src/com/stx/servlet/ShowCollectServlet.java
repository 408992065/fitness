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
import com.stx.dao.IShowCollectDao;
import com.stx.dao.ShowCollectDao;
import com.stx.entity.ShowCollect;

/**
 * Servlet implementation class ShowCollectServlet
 */
@WebServlet("/showcollect")
public class ShowCollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IShowCollectDao cd = new ShowCollectDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("userid"));
		ArrayList<ShowCollect> cases = cd.getAllCollect(userid);
		String json = new Gson().toJson(cases);
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
