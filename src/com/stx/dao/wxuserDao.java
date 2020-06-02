package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.wxuser;
import com.stx.util.JDBCUtil;



public class wxuserDao  implements IwxuserDao {
    private Connection con;
    private PreparedStatement st;
//添加
    public boolean addwxuser(wxuser cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_wxuser values(seq_wxuser.nextval,?,?,?,?,?,?,?,sysdate)");
            st.setString(1, cs.getName());
            st.setDouble(2, cs.getHight());
            st.setDouble(3, cs.getWeight());
            st.setInt(4, cs.getAge());
            st.setString(5, cs.getOpenid());
            st.setInt(6, cs.getGender());
            st.setString(7, cs.getPurl());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
 /**
  *  传入用户 、openid、性别、和姓名进行添加用户 
 * @param wxuser 
 * @return boolean true添加成功  flase 添加失败
 */
    public boolean addWxuserBynameAndDenger(wxuser cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("insert into t_wxuser values(seq_wxuser.nextval,?,?,?,?,?,?,sysdate)");          
            st.setString(1, cs.getName());
            st.setDouble(2, cs.getHight());
            st.setDouble(3, cs.getWeight());
            st.setInt(4, cs.getAge());
            st.setString(5, cs.getOpenid());
            st.setInt(6, cs.getGender());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
//删除
    public boolean deletewxuser(wxuser cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("delete from t_wxuser where caseid=?");
            st.setInt(1, cs.getUserid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

/**
 * 根据用户id修改 年龄、体重、和身高
 * @param wxuser
 * @return boolean true添加成功 false 添加失败	
 */ 
    public boolean editFirstWxuser(wxuser cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_wxuser set hight=?,weight=?, age=? where userid=?");
            st.setDouble(1, cs.getHight());
            st.setDouble(2, cs.getWeight());
            st.setInt(3, cs.getAge());
            st.setInt(4,cs.getUserid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }
//跟新
    public boolean editwxuser(wxuser cs) {
        int n = 0;
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("update t_wxuser set name=?,hight=?,weight=?,age=?,gender=? where userid=?");
            st.setString(1, cs.getName());
            st.setDouble(2, cs.getHight());
            st.setDouble(3, cs.getWeight());
            st.setInt(4, cs.getAge());
            st.setInt(5, cs.getGender());
            st.setInt(6, cs.getUserid());
            n = st.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return n == 1;
    }

//查询所有用户信息...
        public ArrayList<wxuser> getAllwxuser() {
            ArrayList<wxuser> cases = new ArrayList<wxuser>();
            try {
                con = JDBCUtil.getCon();
                st = con.prepareStatement("select userid,name,gander,age,weight,hight from t_wxuser ");
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    wxuser cr = new wxuser(rs.getInt("userid"),rs.getString("name"), rs.getDouble("weight"), rs.getDouble("hight"),rs.getInt("age"),rs.getInt("gander"));
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
   * 查询用户的信息
   *@param userid
   *@return wxuser对象
   */
        public wxuser getwxuser(int userid) {
           wxuser cr =new wxuser();
            try {
                con = JDBCUtil.getCon();
                st = con.prepareStatement("select name,gender,age,weight,hight from t_wxuser where userid=? ");
                st.setInt(1, userid);
                ResultSet rs = st.executeQuery();
                if(rs.next()) {
                    cr = new wxuser(rs.getString("name"), rs.getDouble("hight"), rs.getDouble("weight"),rs.getInt("age"),rs.getInt("gender"));
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.closeCon(con, st);
            }
            return cr;
        }
/**
 * 确保用户是否存在
 * @param openid 
 * @return boolean true 存在、false 不存在
 * 
 */
  public int existUser(String openid) {
	  	int userid=0;
	  try {
          con = JDBCUtil.getCon();
          st = con.prepareStatement("select userid from t_wxuser where openid=?");
          st.setString(1, openid);
          ResultSet rs = st.executeQuery();
          if(rs.next()) {
        	  userid=rs.getInt("userid");
          }
      } catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      } finally {
          JDBCUtil.closeCon(con, st);
      }
      return userid;
  }
}
