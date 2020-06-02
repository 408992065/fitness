package com.stx.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.cvideo;
import com.stx.util.JDBCUtil;

public class cvideoDao implements ICvideoDao {
    private Connection con;
    private PreparedStatement st;
/**
 * 添加教练视频
 * @param cvideo 对象
 * @return true or false
 */
    public boolean addcvideo(cvideo cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_cvideo values(seq_cvideo.nextval,?,?,?,sysdate)");
            st.setString(1, cs.getName());
            st.setString(2, cs.getUrl());
            st.setInt(3, cs.getCoachid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //删除
    public boolean deletecvideo(int cvideoid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_cvideo where cvideoid=?");
            st.setInt(1, cvideoid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //修改
    public boolean editcvideo(cvideo cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_cvideo set name=?,url=?,coachid=?where cvideoid=?");
            st.setString(1, cs.getName());
            st.setString(2, cs.getUrl());
            st.setInt(3, cs.getCoachid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //查询教练返回视频
    public ArrayList<cvideo> getAllcvideo() {
        ArrayList<cvideo> cases = new ArrayList<cvideo>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select name,url,coachid,ctime from t_cvideo  ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cvideo cr = new cvideo(rs.getString("name"), rs.getString("url"), rs.getInt("coachid"), rs.getString("ctime"));
                cases.add(cr);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }
    /**查询某个教练的视频
     * @param coachid
     * @return  ArrayList<cvideo>
     */
    public ArrayList<cvideo> getcvideo(int coachid) {
        ArrayList<cvideo> cases = new ArrayList<cvideo>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select cvideoid,name,url,coachid,to_char(ctime,'YYYY-MM-DD  hh:mi:ss') ctime from t_cvideo where coachid=? order by cvideoid desc");
            st.setInt(1, coachid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cvideo cr = new cvideo(rs.getInt("cvideoid"),rs.getString("name"), rs.getString("url"), rs.getInt("coachid"), rs.getString("ctime"));
                cases.add(cr);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }
    /**查询视频
     * @param cvideoid
     * @return cvideo
     */
    public cvideo getOneCVideo(int cvideoid) {
    	cvideo cr = new cvideo();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select cvideoid,name,url,coachid,to_char(ctime,'YYYY-MM-DD  hh:mm:ss') ctime from t_cvideo where  cvideoid=? ");
            st.setInt(1,  cvideoid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                 cr = new cvideo(rs.getInt("cvideoid"),rs.getString("name"), rs.getString("url"), rs.getInt("coachid"), rs.getString("ctime"));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cr;
    }
 
}
