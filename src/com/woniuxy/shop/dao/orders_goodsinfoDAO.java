package com.woniuxy.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.woniuxy.shop.dao.po.orders_goodsinfoPO;
import com.woniuxy.shop.tools.C3P0Util;
//import com.woniuxy.shop.tools.JDBCConnection;
/**
 * 订单信息，商品信息数据交互
 * @author Administrator
 *
 */
public class orders_goodsinfoDAO {
	//通过用户id查找订单信息
	public List<orders_goodsinfoPO> findOrderByUid(int uid) {
		List<orders_goodsinfoPO> list = new ArrayList<orders_goodsinfoPO>();
	//	JDBCConnection jdbc = new JDBCConnection();
		Connection con = C3P0Util.getCon();
		String sql = "select * from orders_goodsinfo where uid = ?";
		try {
			PreparedStatement state = con.prepareStatement(sql);
			state.setInt(1, uid);
			ResultSet set = state.executeQuery();
			
			while(set.next()){
				orders_goodsinfoPO po = new orders_goodsinfoPO();
				po.setGid(set.getInt("gid"));
				po.setGimg(set.getString("gimg"));
				po.setGname(set.getString("gname"));
				po.setOnum(set.getInt("onum"));
				po.setPrice(set.getDouble("price"));
				po.setTime(set.getString("time"));
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
