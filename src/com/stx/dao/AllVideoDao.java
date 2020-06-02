package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.stx.entity.Allvideo;
import com.stx.util.JDBCUtil;

public class AllVideoDao implements IAllVideoDao{

	  private Connection con;
	    private PreparedStatement st;

		  /**
	        * 查出用户上传正在指导的视频信息
	   * @param userid
	   * @return ArrayList<Allvideo>
	   */
	  	  public ArrayList<Allvideo> getAllGuidance(int userid) {
	  	        ArrayList<Allvideo> cases = new ArrayList<Allvideo>();
	  	        try {
	  	            con = JDBCUtil.getCon();
	  	            st = con.prepareStatement("select v.videoid,c.coachid,c.name,j.url,v.description,to_char(v.ctime,'YYYY-MM-DD  hh:mi:ss'),\r\n" + 
	  	            		"from t_video v,t_coach c,t_jphoto j\r\n" + 
	  	            		"where v.userid=? and v.coachid=c.coachid and  c.coachid=j.coachid and v.status=0 \r\n" + 
	  	            		"order by v.videoid desc");
	  	            st.setInt(1, userid);
	  	            ResultSet rs = st.executeQuery();
	  	            while (rs.next()) {
	  	            	Allvideo cr = new Allvideo(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
	  	                cases.add(cr);
	  	            }
	  	        } catch (ClassNotFoundException | SQLException e) {
	  	            e.printStackTrace();
	  	        } finally {
	  	            JDBCUtil.closeCon(con, st);
	  	        }
	  	        return cases;
	  	    }
}
