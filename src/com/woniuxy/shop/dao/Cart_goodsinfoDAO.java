package com.woniuxy.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.shop.dao.po.Cart_goodsinfoPO;
import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 购物车商品信数据交互
 * @author Administrator
 *
 */
public class Cart_goodsinfoDAO {
	//根据uid查找商品商品信息
	public List<Cart_goodsinfoPO> findCartInfoByUid(int uid) {
		List<Cart_goodsinfoPO> list = new ArrayList<Cart_goodsinfoPO>();
		//JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "SELECT * FROM cart_goodsinfo where uid = ? and cflag = 1";
		try {
			//sql预编译
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			ResultSet set = state.executeQuery();
			while(set.next()){
				Cart_goodsinfoPO po = new Cart_goodsinfoPO();
				//将查询结果存入到po中
				po.setCflag(set.getInt("cflag"));
				po.setCnum(set.getInt("cnum"));
				po.setGimg(set.getString("gimg"));
				po.setGname(set.getString("gname"));
				po.setPrice(set.getDouble("price"));
				po.setTotal(set.getInt("total"));
				po.setGid(set.getInt("gid"));
				po.setCid(set.getInt("cid"));
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
