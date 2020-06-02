package com.stx.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.stx.dao.IrtalkDao;
import com.stx.dao.rtalkDao;
import com.stx.entity.rtalk;

/**
 * Servlet implementation class AddRTalkServlet
 */
@WebServlet("/addrtalk")
public class AddRTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IrtalkDao dao = new rtalkDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int recipesid = Integer.parseInt(request.getParameter("recipesid"));
		String content = request.getParameter("content");
		rtalk cs = new rtalk(recipesid,userid,content);
		if (dao.addrtalk(cs)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", 1);
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
