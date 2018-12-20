package com.woniuxy.shop.service;

import com.woniuxy.shop.dao.CartDAO;
/**
 * 结账功能逻辑处理
 * @author Administrator
 *
 */
public class InvoicingService {

	public int payByUid(int uid) {
		//1：库存不够 2：余额不够 3：结账成功
		int re = 0;
		//传入uid执行支付
		re = new CartDAO().pay(uid);
		return re;
	}

}
