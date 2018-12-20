package com.woniuxy.shop.tools;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static ComboPooledDataSource pool = new ComboPooledDataSource();
	static{
		//加载数据驱动
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		//设置url
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/shopweb");
		//设置用户名
		pool.setUser("root");
		//设置密码
		pool.setPassword("");
		//设置连接池初始连接数
		pool.setInitialPoolSize(15);
		//连接池最大连接数
		pool.setMaxPoolSize(50);
	}
	public static Connection getCon(){
		Connection con = null;
		try {
			con = pool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
