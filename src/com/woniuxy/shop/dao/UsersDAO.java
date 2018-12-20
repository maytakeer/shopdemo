package com.woniuxy.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 用户信息数据交互
 * @author Administrator
 *
 */
public class UsersDAO {
	//查找用户密码
	public String findPassByName(String username) {
		String pass = "";
		//JDBCConnection jdbc = new JDBCConnection();
		//C3P0Util jdbc = new C3P0Util();
		Connection con = C3P0Util.getCon();
		String sql = "select pass from user where address=?";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, username);
			ResultSet set = prepareStatement.executeQuery();
			while(set.next()){
				pass = set.getString("pass");
			}
		//	System.out.println(pass);
			set.close();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return pass;
	}
	//添加用户
	public boolean addUser(String name, String pass) {
		boolean bl = false;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "INSERT INTO `user`(address,pass) VALUES (?,?)";
		try {
			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, pass);
			int re = prepareStatement.executeUpdate();
			if(re > 0){
				bl = true;
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return bl;
	}
	//查找用户id
	public int findId(String username) {
		int id = 0;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select id from user where address = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, username);
			ResultSet set = state.executeQuery();
			while(set.next()){
				id = set.getInt("id");
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return id;
	}
	//更新用户密码
	public void changePass(String username, String md5ofStr) {
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "update user set pass = ? where address = ? ";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setString(1, md5ofStr);
			state.setString(2, username);
			int i = state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
	}
	//添加userinfo表
	public void addUserInfo(int id) {
		Connection con = C3P0Util.getCon();
		String sql = "INSERT INTO `userinfo`(uid) VALUES (?)";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
	}

}
