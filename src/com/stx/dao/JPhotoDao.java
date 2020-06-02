package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stx.entity.JPhoto;
import com.stx.util.JDBCUtil;

public class JPhotoDao implements IJPhotoDao {

	 private Connection con;
	    private PreparedStatement st;
	    /**
	     * 修改教练照片
	     * @param jPhoto
	     * @return boolean true 修改成功，false修改失败
	     */
	    public boolean updateJPhoto( JPhoto cs) {
	        int n = 0;
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("update t_jphoto set url=? where coachid=?");
	            st.setString(1, cs.getUrl());
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
	     * 添加教练照片
	     * @param JPhoto 对象
	     * @return boolean true 添加成功，false添加失败
	     */
	    public boolean addJPhoto( JPhoto cs) {
	        int n = 0;
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("insert into t_jphoto values(seq_jphoto.nextval,?,?,sysdate)");
	            st.setString(1, cs.getUrl());
	            st.setInt(2, cs.getCoachid());
	            n = st.executeUpdate();
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.closeCon(con, st);
	        }
	        return n == 1;
	    }
}
