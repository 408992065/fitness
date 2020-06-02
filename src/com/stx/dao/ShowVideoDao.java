package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.ShowVideo;
import com.stx.util.JDBCUtil;

public class ShowVideoDao implements IShowVideoDao{
	private Connection con;
	private PreparedStatement st;

	/**
	 * 查找学员给某个教练上传的所有视频
	 * 
	 * @param coachid
	 * @return ArrayList<ShowVideo>
	 */
	public ArrayList<ShowVideo> searchVideoOfStu(int coachid) {
		 ArrayList<ShowVideo> cases = new ArrayList<ShowVideo>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("  select videoid,u.name uname,url,description,to_char(v.ctime,'YYYY-MM-DD hh:mi:ss') \r\n" + 
					"  from t_video v,t_wxuser u\r\n" + 
					"  where coachid=? and status=0 and v.userid=u.userid\r\n" + 
					"  order by videoid desc");
			st.setInt(1, coachid);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				ShowVideo sv = new ShowVideo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				cases.add(sv);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return cases;
	}
	/**
	 * 查找某个视频的信息
	 * 
	 * @param videoid
	 * @return ShowVideo
	 */
	public ShowVideo searchVideo(int videoid) {
		 ShowVideo sv= new ShowVideo();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select videoid,u.name uname,url,description,to_char(v.ctime,'YYYY-MM-DD hh:mm:ss')\r\n" + 
					"from t_video v,t_wxuser u\r\n" + 
					"where videoid=?  and v.userid=u.userid");
			st.setInt(1, videoid);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				sv = new ShowVideo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeCon(con, st);
		}
		return sv;
	}
}
