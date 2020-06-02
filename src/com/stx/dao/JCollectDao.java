package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stx.entity.jcollect;
import com.stx.util.JDBCUtil;

public class JCollectDao implements IJCollectDao{
	   private Connection con;
	    private PreparedStatement st;
	/**
	 * 删除教练视频收藏
	 * @param jcollectid
	 * @return boolean 成功true false 失败
	 */
	public boolean deleteCollect(int jcollectid) {
		  int n = 0;
          try {
              con = JDBCUtil.getCon();
              st = con.prepareStatement("delete from t_jcollect where jcollectid=?");
              st.setInt(1, jcollectid);
              n = st.executeUpdate();
          } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
          } finally {
              JDBCUtil.closeCon(con, st);
          }
          return n == 1;
      }
	   /**
     * 判读教练视频是否被用户收藏
     * @param cvideoid and userid
     * @return 0不存在 or 1 存在
     * 
     */
    public int existJCollect( int userid,int cvideoid) {
    	int jcollectid=0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select jcollectid from t_jcollect where userid=? and cvideoid=?");
            st.setInt(1,userid);
            st.setInt(2,cvideoid);
            ResultSet rs=st.executeQuery();
            if(rs.next()) {
            	jcollectid=rs.getInt(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return jcollectid;
    }
    /**
     * 添加教练的视频收藏
     * @param jcollect 对象
     * @return boolean true 添加成功，false添加失败
     */
    public boolean addJCollect( jcollect cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_jcollect values(seq_jcollect.nextval,?,?,sysdate)");
            st.setInt(1, cs.getCvideoid());
            st.setInt(2, cs.getUserid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
	}

