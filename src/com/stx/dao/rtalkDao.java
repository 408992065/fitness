package com.stx.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowRTalk;
import com.stx.entity.ShowUserRTalk;
import com.stx.entity.rtalk;
import com.stx.util.JDBCUtil;

public class rtalkDao implements IrtalkDao {
    private Connection con;
    private PreparedStatement st;
//添加
    public boolean addrtalk( rtalk cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_rtalk values(seq_rtalk.nextval,?,?,?,sysdate)");
            st.setInt(1, cs.getRecipesid());
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
    public boolean deletertalk(int rtalkid ) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_rtalk where rtalkid=?");
            st.setInt(1, rtalkid);
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //查询食谱评论
    public ArrayList<rtalk> getAllralk() {
        ArrayList<rtalk> cases = new ArrayList<rtalk>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select rtalkid,recipesid,userid,description,cimte from t_rtalk");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                rtalk cr = new rtalk( rs.getInt("rtalkid"),rs.getInt("recipesid"), rs.getInt("userid"),rs.getString("description"),  rs.getString("cimte"));
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
     * 查询某个食谱的评论
     * @param recipeesid
     * @return 食谱所有评论  ArrayList<ShowRTalk>
     */
    public ArrayList<ShowRTalk> getralk(int recipesid) {
    	ArrayList<ShowRTalk> cases = new ArrayList<ShowRTalk> ();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select rtalkid,w.name name,description,to_char(r.ctime,'YYYY-MM-DD hh:mi:ss') ctime from t_rtalk r,t_wxuser w where r.recipesid = ? and r.userid=w.userid order by rtalkid");
            st.setInt(1, recipesid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	ShowRTalk  cr = new ShowRTalk ( rs.getInt("rtalkid"),rs.getString("name"),rs.getString("description"), rs.getString("ctime"));
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
     * 查询用户的所有食谱评论
     * @param ruserid
     * @return 用户所有食谱评论  ArrayList<ShowUserRTalk>
     */
    public ArrayList<ShowUserRTalk> getUserRTalk(int userid) {
    	ArrayList<ShowUserRTalk> cases = new ArrayList<ShowUserRTalk>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select rtalkid ,x.name uname, t.description, to_char(t.ctime,'YYYY-MM-DD  hh:mi:ss') ctime, r.name rname ,calorie, needfood, url from t_rtalk t,t_wxuser x,t_rphoto p ,t_recipes r where t.userid=? and t.userid=x.userid and t.recipesid=r.recipesid and t.recipesid=p.recipesid order by  rtalkid desc");
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	ShowUserRTalk  cr = new ShowUserRTalk(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
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
