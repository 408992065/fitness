package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.entity.UserNumber;
import com.stx.util.JDBCUtil;

public class UserNumberDao implements IUserNumberDao{
	private Connection con;
    private PreparedStatement st;
	
	/**
	 * 查出用户视频收藏、菜谱收藏、关注教练的总数量
	 * @param userid
	 * @return UserNumber
	 */
    public UserNumber getAllNumber(int userid) {
    	UserNumber cr = new UserNumber();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select * from (select count(rcollectid) rnumber from t_rcollect where userid=?) r,\r\n" + 
            		"(select count(followid) cnumber from t_follow where userid=?) c,\r\n" + 
            		"( select count(jcollectid) vnumber from t_jcollect where userid=?) j");
            st.setInt(1, userid);
            st.setInt(2, userid);
            st.setInt(3, userid);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
            	cr = new UserNumber(rs.getInt(1),rs.getInt(2),rs.getInt(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cr;
    }
}
