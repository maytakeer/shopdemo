package com.woniuxy.shop.service;

import java.util.List;

import com.woniuxy.shop.dao.orders_goodsinfoDAO;
import com.woniuxy.shop.dao.po.orders_goodsinfoPO;
/**
 * 订单信息逻辑处理
 * @author Administrator
 *
 */
public class ShowOrderService {

	public List<orders_goodsinfoPO> showOrder(int uid) {
		//存储订单信息
		List<orders_goodsinfoPO> list = null;
		//返回订单信息
		list = new orders_goodsinfoDAO().findOrderByUid(uid);
		return list;
	}

}
