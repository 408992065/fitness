package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.entity.RCollect;
import com.stx.util.JDBCUtil;

public class RCollectDao implements IRCollectDao {

	private Connection con;
	private PreparedStatement st;

	/**
	 * 删除菜谱收藏
	 * 
	 * @param jcollectid
	 * @return boolean 成功true false 失败
	 */
	public boolean deleteCollect(int rcollectid) {
		int n = 0;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("delete from t_rcollect where rcollectid=?");
			st.setInt(1, rcollectid);
			n = st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return n == 1;

	}
	/**
	 * 判断菜谱是否被用户收藏
	 * @param userid and recipesid
	 * @return true or false
	 */
	public int existRCOllect(int userid,int recipesid) {
		int rcollectid = 0;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select rcollectid from t_rcollect where userid=? and recipesid=?");
			st.setInt(1, userid);
			st.setInt(2, recipesid);
			ResultSet  rs= st.executeQuery();
			if(rs.next()) {
				rcollectid=rs.getInt(1);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return rcollectid;
	}
	/**
	 * 添加收藏
	 * @param rcollect
	 * @return true or false
	 */
	public boolean addRCOllect(RCollect rc) {
		int n = 0;
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("insert into t_rcollect values(seq_rcollect.nextval,?,?,sysdate)");
			st.setInt(1, rc.getRecipesid());
			st.setInt(2, rc.getUserid());
			n = st.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return n==1;
	}
}
