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
import com.stx.dao.IJtalkDao;
import com.stx.dao.JtalkDao;
import com.stx.entity.Jtalk;

/**
 * Servlet implementation class Add
 */
@WebServlet("/addjtalk")
public class AddJTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IJtalkDao dao =new JtalkDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int cvideoid = Integer.parseInt(request.getParameter("cvideoid"));
		String content = request.getParameter("content");
		Jtalk cs = new Jtalk(cvideoid,userid,content);
		if (dao.addJtalk(cs)) {
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
