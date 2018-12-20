package com.woniuxy.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shop.dao.po.UserInfoPO;
import com.woniuxy.shop.dto.UserInfoDTO;
import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 用户详细信息数据交互
 * @author Administrator
 *
 */
public class UserInfoDAO {
	//查找用户余额
	public List<UserInfoPO> findBalanceBy(int uid) {
		List<UserInfoPO> list = new ArrayList<UserInfoPO>();
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select balance from userinfo where uid = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			ResultSet set = state.executeQuery();
			while(set.next()){
				UserInfoPO po = new UserInfoPO();
				po.setBalance(set.getDouble("balance"));
				list.add(po);
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return list;
	}
	//添加用户信息
	public boolean addUserInfoById(UserInfoDTO dto) {
		boolean bl = false;
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "insert into email(mail,realname,address,phone,uid) values (?,?,?,?,?)";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(5, dto.getUid());
			state.setString(1, dto.getEmail());
			state.setString(2, dto.getRealname());
			state.setString(3, dto.getAddress());
			state.setString(4, dto.getPhone());
			int re = state.executeUpdate();
			if(re>0){
				bl = true;
			}
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return bl;
	}
	//查找用户详细信息
	public List<UserInfoPO> findUserInfo(int uid) {
		List<UserInfoPO> list = new ArrayList<UserInfoPO>();
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select id,mail,realname,address,phone from email where uid=? and flag=1";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			ResultSet set = state.executeQuery();
			while(set.next()){
				UserInfoPO po = new UserInfoPO();
				po.setAddress(set.getString("address"));
				po.setMail(set.getString("mail"));
				po.setPhone(set.getString("phone"));
				po.setRealname(set.getString("realname"));
				po.setEid(set.getInt("id"));
				list.add(po);
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return list;
	}
//查找用户详细信息通过id
	public List<UserInfoPO> findByEid(int id) {
		List<UserInfoPO> list = new ArrayList<UserInfoPO>();
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select mail,realname,address,phone from email where id = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet set = state.executeQuery();
			while(set.next()){
				UserInfoPO po = new UserInfoPO();
				po.setAddress(set.getString("address"));
				po.setMail(set.getString("mail"));
				po.setPhone(set.getString("phone"));
				po.setRealname(set.getString("realname"));
				list.add(po);
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return list;
	}
//删除用户信息
	public void delUserInfoById(int eid) {
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		//String sql = "delete from email where id = ?";
		String sql = "update email set flag = 0 where id = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1,eid);
			state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
	}

}
