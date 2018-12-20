package com.woniuxy.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shop.dao.po.GoodsPO;
import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 商品信息数据交互
 * @author Administrator
 *
 */
public class GoodsDAO {
	//查找商品信息6条
	public List<GoodsPO> findGoods(int i) {
		List<GoodsPO> list = new ArrayList<GoodsPO>();
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select gname,price,gimg,id from goodsinfo limit ?,6";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, i);
			ResultSet set = state.executeQuery();
			while(set.next()){
				GoodsPO po = new GoodsPO();
				po.setId(set.getInt("id"));
				po.setGname(set.getString("gname"));
				po.setPrice(set.getDouble("price"));
				po.setGimg(set.getString("gimg"));
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
	//查找商品信息条数
	public int findIndex() {
		int row = 0;
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select count(*) as 'index' from goodsinfo";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			ResultSet set = state.executeQuery();
			while (set.next()) {
				row = set.getInt("index");
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return row;
	}
	//通过商品id查找商品信息
	public List<GoodsPO> findGoodsInfoById(int id) {
		List<GoodsPO> list = new ArrayList<GoodsPO>();
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select * from goodsinfo where id = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, id);
			ResultSet set = state.executeQuery();
			while(set.next()){
				GoodsPO po = new GoodsPO();
			//	System.out.println(set.getString("gimg"));
				po.setGimg(set.getString("gimg"));
				po.setGname(set.getString("gname"));
				po.setInfo(set.getString("info"));
				po.setNumber(set.getInt("number"));
				po.setPrice(set.getDouble("price"));
				po.setTotal(set.getInt("total"));
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
	//传入商品id查找对应商品数量
	public int findNumber(int goodsid) {
		int num = 0;
	//	JDBCConnection jdbc = new  JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select total from goodsinfo where id = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, goodsid);
			ResultSet set = state.executeQuery();
			while(set.next()){
				num = set.getInt("total");
			}
			set.close();
			state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeCon(con);
		return num;
	}
	
	public List<GoodsPO> findGoods(int i, Connection con) {
		List<GoodsPO> list = new ArrayList<GoodsPO>();
		//JDBCConnection jdbc = new JDBCConnection();
		//Connection con = C3P0Util.getCon();
		String sql = "select gname,price,gimg,id from goodsinfo limit ?,6";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, i);
			ResultSet set = state.executeQuery();
			while(set.next()){
				GoodsPO po = new GoodsPO();
				po.setId(set.getInt("id"));
				po.setGname(set.getString("gname"));
				po.setPrice(set.getDouble("price"));
				po.setGimg(set.getString("gimg"));
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

}
