package com.woniuxy.shop.service;

import com.woniuxy.shop.dao.CartDAO;
import com.woniuxy.shop.dao.GoodsDAO;
/**
 * 购物车添加
 * @author Administrator
 *
 */
public class ShoppingCart {

	public int addGoods(int uid, String gid, String buynum) {
		//boolean bl = false;
		//0：添加商品数量不能零 1：添加数量大于库存数 2：添加成功		
		int re = 0;
		//商品id
		int goodsid = 0;
		//商品添加数量
		int bnum = 0;
		//将商品id和购买数量转化为int类型
		try {
			goodsid = Integer.parseInt(gid);
			bnum = Integer.parseInt(buynum);
		} catch (Exception e) {
			
		}
		//购买数量小于0
		if(bnum <= 0){
			return re;
		}
		//查找库存数量
		int stocknum = new GoodsDAO().findNumber(goodsid);
		System.err.println("库存数量："+stocknum);
	//	System.out.println("*********"+stocknum);
		//判断库存数量是否小于购买数量
		if(stocknum < bnum){
			re = 1;
			return re;
		}
	//	System.out.println("*********end");
		CartDAO dao = new CartDAO();
		//查找购物车中对应商品用户的商品数量
		int num = dao.findGoods(uid,goodsid);
		//需要添加商品的总数量
		int totalnum = num + bnum;
		//判断购物车中是否已近存在该商品
		if(num > 0){
			//更新商品数量
			boolean bl = dao.insertHaveGoods(uid,goodsid,totalnum);
			if(bl){
				re = 2;
				return re;
			}
		}else{
			//添加购物车信息
			boolean bl = dao.insertGoods(uid,goodsid,bnum);
			if(bl){
				re = 2;
				return re;
			}
		}
		return re;
	}

}
