package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowMenu;
import com.stx.util.JDBCUtil;

public class MenuDao implements IMenuDao{
	  private Connection con;
	    private PreparedStatement st;	
/**
 * 查询用户收藏的菜谱
 * @param userid
 * @return Array<ShowMenu> 
 */
	 public ArrayList<ShowMenu> getAllMenu(int userid) {
	        ArrayList<ShowMenu> cases = new ArrayList<ShowMenu>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select rcollectid,r.recipesid,name,calorie, needfood ,description1,url,to_char(c.ctime,'YYYY-MM-DD  hh:mi:ss') ctime\r\n" + 
	            		"from  t_recipes r,t_rcollect c,t_rphoto p\r\n" + 
	            		"where c.userid=? and c.recipesid=p.recipesid and c.recipesid=r.recipesid\r\n" + 
	            		"order by c.rcollectid");
	            st.setInt(1, userid);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	               ShowMenu sc = new ShowMenu(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
	               cases.add(sc);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        } finally {
	            JDBCUtil.closeCon(con, st);
	        }
	        return cases;
	    }
	 /**
	  * 查询某一个食谱
	  * @param recipesid
	  * @return recipes对象
	  */
	     public ShowMenu getRecipes(int recipesid) {
	         ShowMenu cases = new ShowMenu();
	         try {
	             con = JDBCUtil.getCon();
	             st = con.prepareStatement("select r.recipesid ,r.name,calorie,needfood,description1,url from t_recipes r,t_rphoto p where r.recipesid=? and r.recipesid=p.recipesid");
	             st.setInt(1, recipesid);
	             ResultSet rs = st.executeQuery();
	             while (rs.next()) {
	             	cases = new ShowMenu(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6));
	             }
	         } catch (ClassNotFoundException | SQLException e) {
	             e.printStackTrace();
	         } finally {
	             JDBCUtil.closeCon(con, st);
	         }
	         return cases;
	     }
	     /**
		  *用菜谱名来查询食谱
		  * @param rname
		  * @return ArrayList<ShowMenu>对象
		  */
		     public ArrayList<ShowMenu> getMenu(String name,int current ,int number) {
		    	 ArrayList<ShowMenu> cases =new ArrayList<ShowMenu>();
		         try {
		             con = JDBCUtil.getCon();
		             st = con.prepareStatement("select r.recipesid recipesid,r.name name,r.calorie calorie,r.needfood needed,p.url url \r\n" + 
		             		"from t_recipes r,t_rphoto p\r\n" + 
		             		"where r.recipesid=p.recipesid and r.name like '%"+name+"%' and 0<=rownum and rownum<=?");
		             st.setInt(1, current+number);
		             ResultSet rs = st.executeQuery();
		             while (rs.next()) {
		            	 ShowMenu sm = new ShowMenu(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
		            	 cases.add(sm);
		             }
		         } catch (ClassNotFoundException | SQLException e) {
		             e.printStackTrace();
		         } finally {
		             JDBCUtil.closeCon(con, st);
		         }
		         return cases;
		     }
}
