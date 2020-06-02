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
import com.stx.dao.FollowDao;
import com.stx.dao.IFollowDao;
import com.stx.entity.Follow;

/**
 * Servlet implementation class AddFollowServlet
 */
@WebServlet("/addfollow")
public class AddFollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFollowDao dao=new FollowDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("userid"));
		int coachid=Integer.parseInt(request.getParameter("coachid"));
		if (dao.addFollow(new Follow(userid,coachid))) {
			int followid= dao.existFollow(userid, coachid);
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("followid",followid);
			String json = new Gson().toJson(map);
			Writer out = response.getWriter();
			out.write(json);
			out.flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
