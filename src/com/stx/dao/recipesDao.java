package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.recipes;
import com.stx.util.JDBCUtil;


public class recipesDao implements IrecipesDao{
	//添加
	        private Connection con;
	        private PreparedStatement st;
	        public boolean addrecipes(recipes cs) {
	            int n = 0;
	            try {
	                con = JDBCUtil.getCon();
	                st = con.prepareStatement("insert into t_recipes values(seq_recipes.nextval,?,?,?,?,sysdate)");
	                st.setString(1, cs.getName());
	                st.setDouble(2, cs.getCalorie());
	                st.setString(3, cs.getNeedfood());
	                st.setString(4, cs.getDescription1());
	                n = st.executeUpdate();
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            } finally {
	                JDBCUtil.closeCon(con, st);
	            }
	            return n == 1;
	        }

	        //删除
	        public boolean deleterecipes(recipes cs) {
	            int n = 0;
	            try {
	                con = JDBCUtil.getCon();
	                st = con.prepareStatement("delete from t_recipes where recipesid=?");
	                st.setInt(1, cs.getRecipesid());
	                n = st.executeUpdate();
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            } finally {
	                JDBCUtil.closeCon(con, st);
	            }
	            return n == 1;
	        }

	//修改
	        public boolean editrecipes(recipes cs) {
	            int n = 0;
	            try {
	                con = JDBCUtil.getCon();
	                st = con.prepareStatement("update t_recipes set name=?,calorie=?,description=?, description1=? where recipesid=?");
	                st.setString(1, cs.getName());
	                st.setDouble(2, cs.getCalorie());
	                st.setString(3, cs.getNeedfood());
	                st.setString(4, cs.getDescription1());
	                n = st.executeUpdate();
	            } catch (ClassNotFoundException | SQLException e) {
	                e.printStackTrace();
	            } finally {
	                JDBCUtil.closeCon(con, st);
	            }
	            return n == 1;
	        }


	    //查询食谱..
	    public ArrayList<recipes> getAllrecipes() {
	        ArrayList<recipes> cases = new ArrayList<recipes>();
	        try {
	            con = JDBCUtil.getCon();
	            st = con.prepareStatement("select recipesid,name,calorie,needfood,description1 from t_recipes ");
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                recipes cr = new recipes(rs.getInt("recipesid"),rs.getString("name"), rs.getDouble("calorie"),  rs.getString("needfood"), rs.getString("description1"));
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
