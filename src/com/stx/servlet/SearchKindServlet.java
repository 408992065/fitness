package com.stx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.IKindDao;
import com.stx.dao.KindDao;
import com.stx.entity.Kind;

/**
 * Servlet implementation class SearchKindServlet
 */
@WebServlet("/searchkind")
public class SearchKindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IKindDao dao=new KindDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchKindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Kind> list = dao.searchKind();
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
