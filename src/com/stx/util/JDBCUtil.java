package com.stx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC操作的工具类，封装了获得连接和释放资源的操作
 * @author dyl
 *
 */
public class JDBCUtil {

	/**
	 * 返回数据库连接对象
	 * @return Connection
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "hsy", "hsy");
	}
	
	/**
	 * 释放语句对象和连接对象
	 * @param con 连接对象
	 * @param st 语句对象
	 */
	public static void closeCon(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
