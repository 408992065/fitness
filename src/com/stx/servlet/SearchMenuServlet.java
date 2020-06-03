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
import com.stx.dao.IMenuDao;
import com.stx.dao.MenuDao;
import com.stx.entity.ShowMenu;


/**
 * Servlet implementation class SearchMenuServlet
 */
@WebServlet("/searchmenu")
public class SearchMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenuDao rd = new MenuDao();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchMenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int recipesid = Integer.parseInt(request.getParameter("recipesid"));
		ShowMenu rc = rd.getRecipes(recipesid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("menu", rc);
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
