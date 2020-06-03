package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.RecommendJVideo;
import com.stx.util.JDBCUtil;

public class RecommendJVideoDao  implements IRecommendJVideoDao{
	 private Connection con;
	 private PreparedStatement st;	
	
	/**
	 *推荐被收藏最多的两个教练视频
	 *@return ArrayList<RecommendCoach>
	 */
	 public ArrayList<RecommendJVideo> recommendJVideo(int current ,int number) {
		 ArrayList<RecommendJVideo> cases = new ArrayList<RecommendJVideo>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement(" select * from(select j.cvideoid,j.cname ,j.vname, url ,c.count count \r\n" + 
	            		" from ( select v.cvideoid  cvideoid,c.name cname,v.name vname , url\r\n" + 
	            		" from t_cvideo v,t_coach c \r\n" + 
	            		" where v.coachid=c.coachid) j\r\n" + 
	            		" left outer join(select cvideoid ,count(cvideoid) count from t_jcollect  group by cvideoid order by count desc ) c\r\n" + 
	            		" on c.cvideoid =j.cvideoid \r\n" + 
	            		"order by count desc nulls last)\r\n" + 
	            		"where rownum>=0 and rownum<=?");
	            st.setInt(1, current+number);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	            	RecommendJVideo sc = new RecommendJVideo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
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
