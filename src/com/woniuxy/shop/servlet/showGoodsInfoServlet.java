package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.dao.po.GoodsPO;
import com.woniuxy.shop.service.showGoodsInfoService;
/**
 * 商品详情页面
 * @author Administrator
 *
 */
public class showGoodsInfoServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取商品的id
		String gid = request.getParameter("currentgoods");
//		System.out.println(gid);
		//存储商品的信息
		List<GoodsPO> list = null;
		//根据商品id返回商品信息
		list = new showGoodsInfoService().findGoodsInfoById(gid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		//System.out.println("*************");
		map.put("list", list);
//		for (GoodsPO goodsPO : list) {
//			System.out.println(goodsPO.getGimg());
//		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
