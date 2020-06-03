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
 * Servlet implementation class UpdateMyMsgServlet
 */
@WebServlet("/updatemymsg")
public class UpdateMyMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IwxuserDao wd = new wxuserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMyMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double hight =Double.parseDouble((request.getParameter("hight")));
		double weight =Double.parseDouble((request.getParameter("weight")));
		int age =Integer.parseInt(request.getParameter("age"));
		int userid =Integer.parseInt(request.getParameter("userid"));
		int gender =Integer.parseInt(request.getParameter("gender"));
		String name=request.getParameter("name");
		wxuser cs=new wxuser(userid,name,hight,weight,age,gender);
		if(wd.editwxuser(cs)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user",cs);
			String json = new Gson().toJson(map);
			Writer out = response.getWriter();
			out.write(json);
			 out.flush();
		};
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
