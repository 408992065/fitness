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
import com.stx.dao.IShowVideoDao;
import com.stx.dao.ShowVideoDao;
import com.stx.entity.ShowVideo;


/**
 * Servlet implementation class SearchVideoServlet
 */
@WebServlet("/searchvideo")
public class SearchVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IShowVideoDao dao =new ShowVideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int videoid = Integer.parseInt(request.getParameter("videoid"));
		ShowVideo video = dao.searchVideo(videoid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("video", video);
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
