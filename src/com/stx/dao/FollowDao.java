package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.entity.Follow;
import com.stx.util.JDBCUtil;

public class FollowDao implements IFollowDao {
	
	private Connection con;
    private PreparedStatement st;
/**
 *  用户添加关注
 * @param Follow
 * @return boolean true 添加成功 false 添加失败
 */
    public boolean addFollow(Follow cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_follow values(seq_follow.nextval,?,?,sysdate)");
            st.setInt(1, cs.getUserid());
            st.setInt(2, cs.getCoachid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    /**
     * 删除关注
     * @param followid
     * @return boolean true 删除成功 false 删除失败
     */
    public boolean deleteFollow(int followid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_follow where followid=?");
            st.setInt(1, followid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
    /**
     * 用户是否关注了教练
     * @param userid 用户编号  coachid 教练编号s
     * @return followid 0不存  1 存在
     */
    public int existFollow( int userid,int coachid) {
    	int followid=0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select followid from t_follow where userid=? and coachid=?");
            st.setInt(1,userid);
            st.setInt(2,coachid);
            ResultSet rs=st.executeQuery();
            if(rs.next()) {
            	followid=rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return followid;
    }
}
