package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.GuidanceMsg;
import com.stx.util.JDBCUtil;

public class GuidanceMsgDao implements IGuidanceMsgDao {

	private Connection con;
	private PreparedStatement st;

	/**
	 * 教练显示用户上传正在指导的视频信息
	 * 
	 * @param userid
	 * @return ArrayList<Allvideo>
	 */
	public ArrayList<GuidanceMsg> getGuidanceMsg(int userid ,int status) {
		ArrayList<GuidanceMsg> cases = new ArrayList<GuidanceMsg>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement(
					"select v.videoid,v.coachid,u.name,u.purl,v.description,to_char(v.ctime,'YYYY-MM-DD  hh:mi:ss'),status\r\n"
							+ "from t_video v,t_wxuser u\r\n"
							+ "where v.coachid=? and v.userid=u.userid and v.status=? \r\n"
							+ "order by v.videoid desc");
			st.setInt(1, userid);
			st.setInt(2, status);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				GuidanceMsg cr = new GuidanceMsg(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),rs.getInt(7));
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
