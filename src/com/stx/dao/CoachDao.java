package com.stx.dao;

import com.stx.entity.ShowCoach;
import com.stx.entity.coach;
import com.stx.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoachDao implements ICoachDao{
    private Connection con;
    private PreparedStatement st;
    //添加
    public boolean addCoach(coach cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_coach values(seq_coach.nextval,?,?,?,?,?,?,?,?,?,?,?,sysdate)");
            st.setInt(1, cs.getUserid());
            st.setString(2, cs.getWxname());
            st.setString(3, cs.getName());
            st.setString(4, cs.getOpenid());
            st.setInt(5, cs.getAge());
            st.setDouble(6, cs.getHight());
            st.setDouble(7, cs.getWeight());
            st.setInt(8, cs.getGender());
            st.setString(9, cs.getDescription());
            st.setString(10, cs.getCurl());
            st.setDouble(11, cs.getPrice());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
    //删除
    public boolean deleteCoach(coach cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_coach where coachid=?");
            st.setInt(1, cs.getCoachid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //跟新
    public boolean updateCoach(coach cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_coach set name=?,age=?,hight=?,weight=?,gender=?,description=? ,price=? where coachid=?");
            st.setString(1, cs.getName());
            st.setInt(2, cs.getAge());
            st.setDouble(3, cs.getHight());
            st.setDouble(4, cs.getWeight());
            st.setInt(5, cs.getGender());
            st.setString(6, cs.getDescription());
            st.setDouble(7, cs.getPrice());
            st.setInt(8, cs.getCoachid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

    //查询所有教练信息...
    public ArrayList<coach> getAllCoach() {
        ArrayList<coach> cases = new ArrayList<coach>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select userid,wxname,name,openid,age,hight,wight,jgender,description from t_coach ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                coach cr = new coach(rs.getInt("userid"),rs.getString("wxname"),rs.getString("name"), rs.getString("openid"), rs.getInt("age"), rs.getDouble("hight"), rs.getDouble("weight"),  rs.getInt("gander"), rs.getString("description"));
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
     * 查询莫一个教练信息
     * @param coachid
     * @return coach对像
     */
    public ShowCoach getCoach(int coachid) {
    	ShowCoach cr= new ShowCoach();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select c.coachid,name,age,gender,hight,weight,url,description,price from t_coach c,t_jphoto p where c.coachid=? and c.coachid=p.coachid");
            st.setInt(1,coachid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
               cr = new ShowCoach(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7),rs.getString(8),rs.getDouble(9));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return cr;
    }
    /**
     * 通过coachid，性别、名称、查询教练 
     * @param coach
     * @return ArrayList<ShowCoach>
     */
    public ArrayList<ShowCoach> searchCoach(coach ch) {
        ArrayList<ShowCoach> cases = new ArrayList<ShowCoach>();
        try {
            con = JDBCUtil.getCon();
            StringBuilder sb = new StringBuilder("select c.coachid coachid,c.name name,age,gender ,url from t_coach c,t_jphoto p where c.coachid=p.coachid ");
            if(ch.getCoachid()!=0) {
            	sb.append("and c.coachid=?");
            }
            if(ch.getGender()!=0) {
            	sb.append("and gender=?");
            }
            if(!ch.getName().equals("null")){
            	sb.append("and name=?");
            }
            st = con.prepareStatement(sb.toString());
            int index=1;
            if(ch.getCoachid()!=0) {
            	st.setInt(index++, ch.getCoachid());
            }
            if(ch.getGender()!=0) {
            	 st.setInt(index++, ch.getGender());
            }
            if(!ch.getName().equals("null")) {
            	st.setString(index++, ch.getName());
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	ShowCoach cr = new ShowCoach(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5));
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
              *判断该用户是不是教练
     * @param userid 
     * @return coachid
     * 
     */
      public int existCoach(int userid) {
    	  	int coachid=0;
    	  try {
              con = JDBCUtil.getCon();
              st = con.prepareStatement("select coachid from t_coach where userid=?");
              st.setInt(1, userid);
              ResultSet rs = st.executeQuery();
              if(rs.next()) {
            	  coachid=rs.getInt("coachid");
              }
          } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
          } finally {
              JDBCUtil.closeCon(con, st);
          }
          return coachid;
      }
}
