package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowCollect;
import com.stx.util.JDBCUtil;

public class ShowCollectDao implements IShowCollectDao{
	    private Connection con;
	    private PreparedStatement st;	
	/**
	 * 查询用所有收藏的教学视频信息
 	 *@param usrid
	 *@return ArrayList<ShowCollect> 用户所有收藏教学视频
	 */
	 public ArrayList<ShowCollect> getAllCollect(int userid) {
	        ArrayList<ShowCollect> cases = new ArrayList<ShowCollect>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select jcollectid,c.name,v.name,url,to_char(j.ctime,'YYYY-MM-DD hh:mi:ss') ctime from t_jcollect j,t_cvideo v,t_coach c where j.userid=? and j.cvideoid=v.cvideoid and v.coachid=c.coachid order by jcollectid desc");
	            st.setInt(1, userid);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	               ShowCollect sc = new ShowCollect(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
	               cases.add(sc);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.closeCon(con, st);
	        }
	        return cases;
	    }
}
