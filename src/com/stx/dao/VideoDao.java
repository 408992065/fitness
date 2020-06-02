package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.stx.entity.video;
import com.stx.util.JDBCUtil;

public class VideoDao implements IVideoDao {
	private Connection con;
    private PreparedStatement st;
	/**
	 * 添加视频
	 * @param video
	 * @return boolean 添加成功 true 添加失败 false
	 */
    public boolean addvideo(video cs) {
        int n = 0;
        System.out.println(cs.getDescription());
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_video values(seq_video.nextval,?,?,?,?,?,sysdate)");
            st.setInt(1, cs.getCoachid());
            st.setString(2, cs.getUrl());
            st.setInt(3,cs.getUserid());
            st.setInt(4, cs.getStatus());
            st.setString(5, cs.getDescription());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
    /**
     * 删除视频
     * @param videoid
     * @return boolean 删除成功 true 删除失败 false
     */
    public boolean deletteVideo(int videoid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_video where videoid=?");
            st.setInt(1, videoid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
    /**
     * 完成指导
     * @param videoid
     * @return boolean 修改成功 true 修改失败 false
     */
    public boolean updateStatus(int videoid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_video set status=1 where videoid=?");
            st.setInt(1, videoid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
}
