package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.RecommendCoach;
import com.stx.util.JDBCUtil;

public class RecommendCoachDao implements IRecommendCoachDao{
	 private Connection con;
	 private PreparedStatement st;	
	
	/**
	 *推荐教练每次 number人数
	 *@return ArrayList<RecommendCoach>
	 */
	 public ArrayList<RecommendCoach> recommendCoach(int current ,int number) {
		 ArrayList<RecommendCoach> cases = new ArrayList<RecommendCoach>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select* from(select c.coachid,c.name,c.age,c.gender,url,f.count\r\n" + 
	            		"from (select c.coachid,c.name,c.age,c.gender,p.url\r\n" + 
	            		"from t_coach c,t_jphoto p\r\n" + 
	            		"where c.coachid= p.coachid) c left outer join \r\n" + 
	            		"(select count(coachid) count,coachid \r\n" + 
	            		"from t_follow \r\n" + 
	            		"group by coachid\r\n" + 
	            		"order by count desc) f\r\n" + 
	            		"on c.coachid=f.coachid\r\n" + 
	            		"order by count desc nulls last)\r\n" + 
	            		" where 0<=rownum and rownum<=?");
	            st.setInt(1, current+number);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	            	RecommendCoach sc = new RecommendCoach(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
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
