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
import com.stx.dao.IRecommendRecipesDao;
import com.stx.dao.RecommendRecipesDao;
import com.stx.entity.RecommendRecipes;

/**
 * Servlet implementation class RemmendMoreRecipesServlet
 */
@WebServlet("/recommendmorerecipes")
public class RemmendMoreRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRecommendRecipesDao dao =new RecommendRecipesDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemmendMoreRecipesServlet() {
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
		ArrayList<RecommendRecipes> list = dao.recommendMoreRecipes(name, current, number);
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
