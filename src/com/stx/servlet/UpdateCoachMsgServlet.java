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
import com.stx.dao.CoachDao;
import com.stx.dao.ICoachDao;
import com.stx.entity.coach;

/**
 * Servlet implementation class UpdateCoachMsgServlet
 */
@WebServlet("/updatecoachmsg")
public class UpdateCoachMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICoachDao dao=new CoachDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCoachMsgServlet() {
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
		int gender =Integer.parseInt(request.getParameter("gender"));
		int coachid =Integer.parseInt(request.getParameter("coachid"));
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		System.out.println(hight);
		System.out.println(age);
		System.out.println(weight);
		coach ch=new coach(coachid, name, age, hight, weight, gender, description);
		if(dao.updateCoach(ch)) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", 1);
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
