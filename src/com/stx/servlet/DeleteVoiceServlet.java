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
import com.stx.dao.VoiceDao;

/**
 * Servlet implementation class DeleteVoiceServlet
 */
@WebServlet("/deletevoice")
public class DeleteVoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVideoDao dao = new VideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteVoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int voiceid = Integer.parseInt(request.getParameter("voiceid"));
		int videoid = Integer.parseInt(request.getParameter("videoid"));
		VoiceDao dao1 = new VoiceDao();
		if (dao.deletteVideo(videoid) &dao1.deleteVoice(voiceid)) {
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
