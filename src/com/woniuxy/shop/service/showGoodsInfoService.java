package com.woniuxy.shop.service;

import java.util.List;

import com.woniuxy.shop.dao.GoodsDAO;
import com.woniuxy.shop.dao.po.GoodsPO;
import com.woniuxy.shop.dao.po.UserInfoPO;
/**
 * 商品详情逻辑处理
 * @author Administrator
 *
 */
public class showGoodsInfoService {

	public List<GoodsPO> findGoodsInfoById(String gid) {
		List<GoodsPO> list = null;
		//商品id
		int id = 0;
		//将gid转化为int类型
		try {
			id = Integer.parseInt(gid);
		} catch (Exception e) {
		}
		//返回商品详情
		list = new GoodsDAO().findGoodsInfoById(id);
		return list;
	}

	

}
