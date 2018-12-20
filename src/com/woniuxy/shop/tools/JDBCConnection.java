package com.woniuxy.shop.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	private static final String url = "jdbc:mysql://localhost:3306/shopweb";
	private static final String user = "root";
	private static final String pass = "";
	/*
	 * 获取一个数据库连接
	 */
	public Connection getCon(){
		Connection con = null;
		//加载驱动类
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
