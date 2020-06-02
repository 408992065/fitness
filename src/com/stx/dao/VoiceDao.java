package com.stx.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.stx.entity.voice;
import com.stx.util.JDBCUtil;





    public class VoiceDao implements IVoiceDao{
        //添加
        private Connection con;
        private PreparedStatement st;

        public boolean addvoice(voice cs) {
            int n = 0;
            try {
                con = JDBCUtil.getCon();
                st = con.prepareStatement("insert into t_voice values(seq_voice.nextval,?,?,?,?,?,sysdate)");
                st.setString(1, cs.getUrl());
                st.setInt(2, cs.getVideoid());
                st.setInt(3, cs.getCoachid());
                st.setInt(4, cs.getUserid());
                st.setString(5, cs.getVlength());
                n = st.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.closeCon(con, st);
            }
            return n == 1;
        }

        //删除
        public boolean deleteVoice(int voiceid) {
            int n = 0;
            try {
                con = JDBCUtil.getCon();
                st = con.prepareStatement("delete from t_voice where voiceid=?");
                st.setInt(1, voiceid);
                n = st.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtil.closeCon(con, st);
            }
            return n == 1;
        }
       
    }



