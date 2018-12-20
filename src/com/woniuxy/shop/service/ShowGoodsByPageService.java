package com.woniuxy.shop.service;

import java.sql.Connection;
import java.util.List;

import net.sf.ehcache.Ehcache;

import com.woniuxy.shop.dao.GoodsDAO;
import com.woniuxy.shop.dao.po.GoodsPO;
import com.woniuxy.shop.tools.C3P0Util;
import com.woniuxy.shop.tools.EhUtil;
/**
 * 商品信息分页显示逻辑处理
 * @author Administrator
 *
 */
public class ShowGoodsByPageService {
/*
 * 查找商品信息
 */
	public List<GoodsPO> findGoods(String currentpage) {
		List<GoodsPO> list =null;
		//数据库中数据返回的条数
	//	int index = 0;
		//当前页数
		int page = 1;
		//强转currentpage成int类型
		try{
			page = Integer.parseInt(currentpage);
		}catch (Exception e){
			
		}
		GoodsDAO dao = new GoodsDAO();
		//返回商品信息
		list = dao.findGoods((page-1)*6);
		return list;
//		EhUtil eu = new EhUtil();
//		Object o = eu.find("findgoods");
//		List<GoodsPO> list =null;
//		if(o==null){
//			Connection con = C3P0Util.getCon();
//			GoodsDAO dao = new GoodsDAO();
//			list = dao.findGoods((page-1)*6,con);
//			eu.put("findgoods", list);
//		}else{
//			list = (List<GoodsPO>) o;
//		}
//		return list;
	}
	/*
	 * 查找商品的总页数
	 */
	public int findTotalPage() {
		//返回商品信息条数
		int index = new GoodsDAO().findIndex();
		//商品信息每页6条
		if(index % 6 == 0){
			return index / 6;
		}else{
			return (index / 6)+1;
		}
	}
	
}
