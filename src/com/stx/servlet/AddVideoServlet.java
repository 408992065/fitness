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
import com.stx.dao.IVideoDao;
import com.stx.dao.VideoDao;
import com.stx.entity.video;

/**
 * Servlet implementation class AddVideoServlet
 */
@WebServlet("/addvideo")
public class AddVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVideoDao dao = new VideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt(request.getParameter("userid"));
		int coachid=Integer.parseInt(request.getParameter("coachid"));
		String url =request.getParameter("url");
		String description =request.getParameter("description");
		if (dao.addvideo(new video(coachid,userid,url,description))) {
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
