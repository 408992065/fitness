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
import com.stx.dao.IShowfoodDao;
import com.stx.dao.ShowfoodDao;
import com.stx.entity.Showfood;

/**
 * Servlet implementation class MenuCollectServlet
 */
@WebServlet("/showfood")
public class ShowFoodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IShowfoodDao dao = new ShowfoodDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int foodid=Integer.parseInt(request.getParameter("foodid"));
		Showfood food = dao.showFood(foodid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("food", food);
		String json = new Gson().toJson(map);
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
