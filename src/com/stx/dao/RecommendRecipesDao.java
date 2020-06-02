package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.RecommendRecipes;
import com.stx.util.JDBCUtil;

public class RecommendRecipesDao implements IRecommendRecipesDao {
	 private Connection con;
	 private PreparedStatement st;	
	
	/**
	 *推荐两个食谱 按收藏量排序
	 *@return ArrayList<RecommendRecipes>
	 */
	 public ArrayList<RecommendRecipes> recommendRecipes(String name) {
		 ArrayList<RecommendRecipes> cases = new ArrayList<RecommendRecipes>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select r.recipesid recipesid,r.name name,r.calorie calorie,r.needfood needed,r.url url ,c.count count\r\n" + 
	            		"from (select r.recipesid recipesid,r.name name,r.calorie calorie,r.needfood needfood,p.url url\r\n" + 
	            		"from t_recipes r,t_rphoto p\r\n" + 
	            		"where r.needfood like '%"+name+"%' and r.recipesid=p.recipesid) r left outer join(select count(recipesid) count,  recipesid \r\n" + 
	            		"from t_rcollect\r\n" + 
	            		"group by  recipesid\r\n" + 
	            		"order by count desc) c\r\n" + 
	            		"on r.recipesid=c.recipesid\r\n" + 
	            		"where rownum<3\r\n" + 
	            		"order by count desc nulls last  ");
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	            	RecommendRecipes sc = new RecommendRecipes(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6));
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
		 *推荐更多食谱每一次得到5个 按收藏量排序
		 *@return ArrayList<RecommendRecipes>
		 */
		 public ArrayList<RecommendRecipes> recommendMoreRecipes(String name ,int current ,int number) {
			 ArrayList<RecommendRecipes> cases = new ArrayList<RecommendRecipes>();
		        try {
		            con = JDBCUtil.getCon();
		            st = con.prepareStatement("select * from(select r.recipesid recipesid,r.name name,r.calorie calorie,r.needfood needed,r.url url ,c.count count\r\n" + 
		            		"from (select r.recipesid recipesid,r.name name,r.calorie calorie,r.needfood needfood,p.url url\r\n" + 
		            		"from t_recipes r,t_rphoto p\r\n" + 
		            		"where r.needfood like '%"+name+"%' and r.recipesid=p.recipesid) r left outer join(select count(recipesid) count,  recipesid \r\n" + 
		            		"from t_rcollect\r\n" + 
		            		"group by  recipesid\r\n" + 
		            		"order by count desc) c\r\n" + 
		            		"on r.recipesid=c.recipesid\r\n" + 
		            		"order by count desc nulls last  ) \r\n" + 
		            		 "where rownum>= 0 and rownum<=? ");
		            st.setInt(1,0);
		            st.setInt(2,number+current);
		            ResultSet rs = st.executeQuery();
		            while (rs.next()) {
		            	RecommendRecipes sc = new RecommendRecipes(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		               cases.add(sc);
		            }
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		        } finally {
		            JDBCUtil.closeCon(con, st);
		        }
		        return cases;
		    }
}
