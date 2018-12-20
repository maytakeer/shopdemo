package com.woniuxy.shop.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 购物车数据交互
 * @author Administrator
 *
 */
public class CartDAO {
	//传入用户id和商品id查找购物车数据
	public int findGoods(int uid, int goodsid) {
		int num = 0;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select number from cart where uid = ? and gid = ? and flag = 1";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			state.setInt(2, goodsid);
			ResultSet set = state.executeQuery();
			while(set.next()){
				num = set.getInt("number");
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return num;
	}
	//更新购物车中的商品数量
	public boolean insertHaveGoods(int uid, int goodsid, int totalnum) {
		boolean bl = false;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "update cart set number = ? where uid = ? and gid = ? and flag =1";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, totalnum);
			state.setInt(2, uid);
			state.setInt(3, goodsid);
			int re = state.executeUpdate();
			if(re > 0){
				bl = true;
			}
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return bl;
	}
	//添加购物车数据
	public boolean insertGoods(int uid, int goodsid, int bnum) {
		boolean bl = false;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
	//	System.out.println("*************insert");
		String sql = "insert into cart(uid,gid,number) values(?,?,?)";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			state.setInt(2, goodsid);
			state.setInt(3, bnum);
			int re = state.executeUpdate();
			if(re > 0){
				bl = true;
			}
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return bl;
	}
	//删除购物车数据
	public int delCartGoods(int cartid) {
		int re = 0;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "update cart set flag = 0 where id=?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, cartid);
			re = state.executeUpdate();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return re;
	}
	//执行支付的存储过程
	public int pay(int uid) {
		int re = 0;
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "{CALL proc_pay(?,?)}";
		try {
			CallableStatement state = con.prepareCall(sql);
			state.setInt(1, uid);
			state.execute();
			re = state.getInt(2);
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return re;
	}

	

}
