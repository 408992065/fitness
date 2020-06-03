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
import com.stx.dao.IMenuDao;
import com.stx.dao.MenuDao;
import com.stx.entity.RecommendRecipes;
import com.stx.entity.ShowMenu;

/**
 * Servlet implementation class SearchMenuByNameServlet
 */
@WebServlet("/searchmenubyname")
public class SearchMenuByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IMenuDao dao =new MenuDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMenuByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int current =Integer.parseInt(request.getParameter("current"));
		int number =Integer.parseInt(request.getParameter("number"));
		ArrayList<ShowMenu> list = dao.getMenu(name, current, number);
		String json = new Gson().toJson(list);
		Writer out =response.getWriter();
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
