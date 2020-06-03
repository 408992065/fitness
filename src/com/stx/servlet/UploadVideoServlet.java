package com.stx.servlet;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.stx.dao.IVideoDao;
import com.stx.dao.VideoDao;
import com.stx.entity.video;
import com.stx.util.DateUtil;


/**
 * Servlet implementation class UploadVideo
 */
@WebServlet("/uploadvideo")
public class UploadVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVideoDao dao = new VideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      //UserPhoto对象用来存储用户上传的信息
				video vd=new video();
				//下面代码用户处理客户端上传的用户头像操作，其他文件上传一样处理
				boolean isUploadSuccess = false;
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				if (isMultipart) {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					//to-do:这里可以修改要保存文件的目录，webcontent下建的目录
					File file = new File(getServletContext().getRealPath("/uploadvideo"));
					//end
					//如果工程里面没有创建uploadfiledir目录，这里通过代码创建出来
					if (!file.exists()) {
						file.mkdirs();
					}
					System.out.println(file.getAbsolutePath());
					factory.setRepository(file);
					ServletFileUpload upload = new ServletFileUpload(factory);
					try {
						List<FileItem> items = upload.parseRequest(request);
						Iterator<FileItem> iter = items.iterator();
						while (iter.hasNext()) {
							//每次循环处理的都是客户端表单中的一个元素
							//可能是文件，可能是普通本文输入框
							FileItem item = iter.next();
							if (item.isFormField()) {
								//处理普通本文输入框
								//得到输入框的名字item.getFieldName()
								String inputName = item.getFieldName();
								//得到输入框的值item.getString("utf-8")
								String value = item.getString("utf-8");
								if (inputName.equals("coachid")) {
									//表单中输入框name="uname"的情况
									vd.setCoachid(Integer.parseInt(value));
								}else if(inputName.equals("userid")){
									vd.setUserid(Integer.parseInt(value));
								}else if(inputName.equals("description")){
									vd.setDescription(value);}
							} else if (!item.isFormField()) {
								//处理上传文件的情况
								//获取上传文件名，并进行文件保存。这里获取的文件的原名
								String fileName = item.getName();
								//下面将文件名进行处理，重命名为"yyyyMMddHHmmss"形式名字
								String newFileName = DateUtil.getTimeFileName(fileName);
								File uploadedFile = new File(file, newFileName);
								//保存文件到服务器设定的目录下面，示例中即"/uploadfiledir"目录下
								item.write(uploadedFile);
								//将客户端上传的头像保存在服务器的内部地址保存到数据库中
								vd.setUrl("/uploadvideo/" + newFileName);
								//end
								System.out.println("file upload success");
							}
						}
						if(dao.addvideo(vd)) {
						isUploadSuccess = true;}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					//todo:处理上传后的操作
					if (isUploadSuccess) {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("success", 1);
						String json = new Gson().toJson(map);
						Writer out = response.getWriter();
						out.write(json);
						out.flush();
					} else {
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("success", 0);
						String json = new Gson().toJson(map);
						Writer out = response.getWriter();
						out.write(json);
						out.flush();
					}
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
