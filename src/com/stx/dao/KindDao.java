package com.stx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.stx.entity.Kind;
import com.stx.util.JDBCUtil;

public class KindDao implements IKindDao{
	private Connection con;
	private PreparedStatement st;

	public ArrayList<Kind> searchKind() {
		ArrayList<Kind> cases = new ArrayList<Kind>();
		try {
			con = JDBCUtil.getCon();
			st = con.prepareStatement("select kindid,name,kurl,to_char(ctime,'YYYY-MM-DD hh:mi:ss') time from t_kind");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Kind cr = new Kind(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
