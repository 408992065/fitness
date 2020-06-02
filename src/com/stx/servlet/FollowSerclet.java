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
import com.stx.dao.IShowFollowDao;
import com.stx.dao.ShowFollowDao;
import com.stx.entity.ShowFollow;


/**
 * Servlet implementation class FollowSerclet
 */
@WebServlet("/follow")
public class FollowSerclet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IShowFollowDao fd = new ShowFollowDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowSerclet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("userid"));
		
	    ArrayList<ShowFollow> all = fd.getAllFollow(userid);
			String json = new Gson().toJson(all);
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
