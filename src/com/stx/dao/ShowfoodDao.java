package com.stx.dao;

import com.stx.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.Showfood;

public class ShowfoodDao implements IShowfoodDao{

    private Connection con;
    private PreparedStatement st;


    /**
     * 根据食材名称寻找食材
     * @param name
     * @return ArrayList<Showfood>
     */
    public ArrayList<Showfood> searchFood(String name,int current ,int number) {
    	ArrayList<Showfood>  cases=new ArrayList<Showfood>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select f.foodid,k.name kname, f.name fname,calorie,url\r\n" + 
            		"from t_food f,t_fphoto p,t_kind k\r\n" + 
            		"where f.name like '%"+name+"%' and f.kindid=k.kindid and f.foodid=p.foodid and rownum>=0 and rownum<=? ");
            st.setInt(1, current+number);
            ResultSet rs = st.executeQuery();
                while(rs.next()) {
                	Showfood sc = new Showfood(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
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
     * 根据食材id寻找食材
     * @param foodid
     * @return Showfood
     */
    public Showfood showFood(int foodid) {
    	Showfood  sc=new Showfood();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select f.foodid,k.name kname, f.name fname,calorie,description,url\r\n" + 
            		"from t_food f,t_fphoto p,t_kind k\r\n" + 
            		"where f.foodid=? and f.kindid=k.kindid and f.foodid=p.foodid");
            st.setInt(1, foodid);
            ResultSet rs = st.executeQuery();
                if(rs.next()) {
                	sc = new Showfood(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeCon(con, st);
        }
        return sc;
    }


    /**
     * 根据食材种类寻找食材
     * @param kindid
     * @return ArrayList<Showfood>
     */
    public ArrayList<Showfood> searchFoodByKind(int kindid,int current ,int number) {
    	ArrayList<Showfood>  cases=new ArrayList<Showfood>();
        try {
            con = JDBCUtil.getCon();
            st = con.prepareStatement("select f.foodid,k.name kname, f.name fname,calorie,url\r\n" + 
            		"from t_food f,t_fphoto p,t_kind k\r\n" + 
            		"where f.kindid=? and f.kindid=k.kindid and f.foodid=p.foodid and rownum>=0 and rownum<=?");
            st.setInt(1,kindid);
            st.setInt(2,current+number);
            ResultSet rs = st.executeQuery();
                while(rs.next()) {
                	Showfood sc = new Showfood(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
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
