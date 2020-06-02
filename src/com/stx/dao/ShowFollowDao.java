package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowFollow;
import com.stx.util.JDBCUtil;

public class ShowFollowDao implements IShowFollowDao{
	  private Connection con;
	    private PreparedStatement st;	
	/**
	 *查询出用户关注的所有教练
	 *@param userid 
	 *@return ArrayList<ShowFollow>
	 */
	    public ArrayList<ShowFollow> getAllFollow(int userid) {
	        ArrayList<ShowFollow> cases = new ArrayList<ShowFollow>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select followid ,url,c.name ,c.coachid from t_coach c,t_follow f,t_jphoto p where f.userid=? and f.coachid=c.coachid and f.coachid=p.coachid order by followid desc");
	            st.setInt(1, userid);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	            	ShowFollow sc = new ShowFollow(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
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
