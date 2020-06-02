package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.FeedBack;
import com.stx.entity.ShowFeed;
import com.stx.util.JDBCUtil;

public class FeedBackDao implements IFeedBackDao {
    private Connection con;
    private PreparedStatement st;

    public boolean addFeedback(FeedBack cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_feedback values(seq_feedback.nextval,?,?,sysdate)");
            st.setInt(1, cs.getUserid());
            st.setString(2, cs.getContent());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //删除
    public boolean deleteFeedback(int feedbackid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_feedback where feedbackid=?");
            st.setInt(1, feedbackid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //修改
    public boolean editFeedback(FeedBack cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_feedback set feedbackid=?,userid=?,content=? where feedbackid=?");
            st.setInt(1, cs.getFeedbackid());
            st.setInt(2, cs.getUserid());
            st.setString(3, cs.getContent());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //查询意见反馈
    public ArrayList<ShowFeed> getAllFeedback() {
    	 ArrayList<ShowFeed>cases = new  ArrayList<ShowFeed>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select feedbackid,name,content,to_char(c.ctime,'yyyymmdd hh:mi:ss') ctime  from t_feedback ,t_wxuser");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ShowFeed cr = new ShowFeed(rs.getInt("feedbackid"), rs.getString("name"), rs.getString("content"), rs.getString("ctime"));
                cases.add(cr);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }

}
