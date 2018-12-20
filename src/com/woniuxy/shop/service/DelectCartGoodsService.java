package com.woniuxy.shop.service;

import com.woniuxy.shop.dao.CartDAO;
/**
 * 删除购物车商品
 * @author Administrator
 *
 */
public class DelectCartGoodsService {

	public boolean delCartGoodByCid(String cid) {
		boolean bl = false;
		int cartid = 0;
		try {	
			cartid= Integer.parseInt(cid);
		} catch (Exception e) {
			
		}
		int re= new CartDAO().delCartGoods(cartid);
		if(re>0){
			bl = true;
		}
		return bl;
				
	}

	public boolean delCartGoodByCid(String[] arr) {
		//删除结果
		boolean bl = false;
		//购物车id
		int cid = 0;
		//arr为空
		if(arr==null){
			return bl;
		}
		//遍历arr
		for (int i = 0; i < arr.length; i++) {
			try {
				//将arr中的数据转为int类型并赋值给cid
				cid= Integer.parseInt(arr[i]);
			} catch (Exception e) {
				
			}
			//传入购物车id执行删除操作，返回影响的条数
			int re = new CartDAO().delCartGoods(cid);
			//影响的条数大于0
			if(re>0){
				bl = true;
			}			
		}
		return bl;
	}

}
