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
import com.stx.dao.GuidanceMsgDao;
import com.stx.dao.IGuidanceMsgDao;
import com.stx.dao.IShowVideoDao;
import com.stx.dao.ShowVideoDao;
import com.stx.entity.GuidanceMsg;
import com.stx.entity.ShowVideo;

/**
 * Servlet implementation class GuidanceMsgServlet
 */
@WebServlet("/guidancemsg")
public class GuidanceMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IGuidanceMsgDao dao=new GuidanceMsgDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuidanceMsgServlet() {
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
		int status = Integer.parseInt(request.getParameter("status"));
		ArrayList<GuidanceMsg> list = dao.getGuidanceMsg(coachid, status);
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
