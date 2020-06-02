package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowVoice;
import com.stx.util.JDBCUtil;

public class ShowVoiceDao implements IShowVoiceDao {

	private Connection con;
	private PreparedStatement st;

	/**
	 * 查找某一个用户视频的所有语音指导
	 * 
	 * @param voiceid
	 * @return ArrayList<ShowVoice>
	 */
	public ArrayList<ShowVoice> getVoice(int videoid) {
		ArrayList<ShowVoice> cases = new ArrayList<ShowVoice>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select distinct v.voiceid,v.url,v.coachid,v.userid,to_char(v.ctime ,'YYYY-MM-DD hh:mi:ss') ctime,jname,uname ,v.vlength from (select * from t_voice where videoid="+videoid+" order  by ctime) v \r\n" + 
					"full outer join (select name jname,c.coachid from t_coach c,(select * from t_voice where videoid="+videoid+" order  by ctime) v where c.coachid=v.coachid) c\r\n" + 
					"on c.coachid=v.coachid \r\n" + 
					"full outer join (select name uname,u.userid from t_wxuser u,(select * from t_voice where videoid="+videoid+" order  by ctime) v  where u.userid=v.userid) u\r\n" + 
					"on u.userid=v.userid \r\n" + 
					"order by ctime desc");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ShowVoice cr = new ShowVoice(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4) ,rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
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
	 * 查找某一个用户视频的所有语音指导
	 * 
	 * @param videoid
	 * @return ArrayList<voice>
	 */
	public ArrayList<ShowVoice> searchVoice(int videoid) {
		ArrayList<ShowVoice> cases = new ArrayList<ShowVoice>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement(
					"select voiceid,c.name,url,to_char(ctime,'YYYY-MM-DD hh:mm:ss') from t_voice v,t_coach c where videoid=? and v.coachid=c.coachid order by voiceid desc");
			st.setInt(1, videoid);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				ShowVoice vc = new ShowVoice( rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
				cases.add(vc);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return cases;
	}
	
}
