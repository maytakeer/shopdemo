package com.woniuxy.shop.service;

import java.util.List;

import com.woniuxy.shop.dao.Cart_goodsinfoDAO;
import com.woniuxy.shop.dao.po.Cart_goodsinfoPO;
/**
 * 购物车展示逻辑处理
 * @author Administrator
 *
 */
public class ShowShoppingCartService {

	public List<Cart_goodsinfoPO> findCartInfo(int uid) {
		//购物车数据
		List<Cart_goodsinfoPO> list = null;
		Cart_goodsinfoDAO dao = new Cart_goodsinfoDAO();
		//出入购物车id返回购物车信息
		list = dao.findCartInfoByUid(uid);
		return list;
	}

}
