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
import com.stx.dao.IwxuserDao;
import com.stx.dao.wxuserDao;
import com.stx.entity.wxuser;

/**
 * Servlet implementation class ShowMyMsgServlet
 */
@WebServlet("/showmymsg")
public class ShowMyMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IwxuserDao wd = new wxuserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid =Integer.parseInt(request.getParameter("userid"));
		wxuser user = wd.getwxuser(userid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		String json = new Gson().toJson(map);
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
