package com.stx.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.Jtalk;
import com.stx.entity.ShowJTalk;
import com.stx.util.JDBCUtil;

public class JtalkDao implements IJtalkDao{
    private Connection con;
    private PreparedStatement st;
    /**
     * 添加教练视频评论
     * @param Jtalk 对象
     * @return boolean true 添加成功，false添加失败
     */
    public boolean addJtalk( Jtalk cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_jtalk values(seq_jtalk.nextval,?,?,?,sysdate)");
            st.setInt(1, cs.getCvideoid());
            st.setInt(2, cs.getUserid());
            st.setString(3, cs.getDescription());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //删除
    public boolean deleteJtalk(int jtalkid) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_jtalk where jtalkid=?");
            st.setInt(1, jtalkid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
    //查询教练评论
    public ArrayList<Jtalk> getAlljtalk() {
        ArrayList<Jtalk> cases = new ArrayList<Jtalk>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select jtalkid,cvideoid,userid,description,cimte from t_jtalk");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Jtalk cr = new Jtalk(rs.getInt("jkalkid"),rs.getInt("cvideoid"), rs.getInt("userid"),rs.getString("description"),  rs.getString("cimte"));
                cases.add(cr);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }

    /**
     * 用户对所有教练视频的评论
     * @param userid
     * @return  
     */
    public ArrayList<ShowJTalk> getUserJtalk(int userid) {
    	ArrayList<ShowJTalk> cases = new ArrayList<ShowJTalk>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select jtalkid ,x.name uname, j.description, to_char(j.ctime,'YYYY-MM-DD  hh:mi:ss') ctime, url,v.name vname ,c.name \r\n" + 
            		"from t_jtalk j,t_wxuser x,t_cvideo v ,t_coach c \r\n" + 
            		"where j.userid=? and j.userid=x.userid and v.coachid=c.coachid and j.cvideoid=v.cvideoid order by jtalkid desc");
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
             ShowJTalk st = new ShowJTalk(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                cases.add(st);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }
    /**
     * 所有用户对莫一个教练视频的评论
     * @param userid
     * @return  
     */
    public ArrayList<ShowJTalk> getJtalk(int cvideoid) {
    	ArrayList<ShowJTalk> cases = new ArrayList<ShowJTalk>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select jtalkid ,x.name uname, j.description, to_char(j.ctime,'YYYY-MM-DD  hh:mm:ss') ctime\r\n" + 
            		"from t_jtalk j,t_wxuser x,t_cvideo v  \r\n" + 
            		"where j.cvideoid=? and j.userid=x.userid and j.cvideoid=v.cvideoid order by jtalkid desc");
            st.setInt(1, cvideoid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
             ShowJTalk st = new ShowJTalk(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),cvideoid);
                cases.add(st);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cases;
    }
}
