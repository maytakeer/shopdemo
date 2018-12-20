package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.dao.po.GoodsPO;
import com.woniuxy.shop.service.ShowGoodsByPageService;
/**
 * 分页显示商品详情
 * @author Administrator
 *
 */
public class ShowGoodsByPageServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码方式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//当前页数
		String currentpage = request.getParameter("page");	
	//	System.out.println(currentpage);
		Map<String,Object> map = new HashMap<String,Object>();
		//用于存储商品信息
		List<GoodsPO> list = null;
		//实例化
		ShowGoodsByPageService service = new ShowGoodsByPageService();
		//页面商品数据
		list = service.findGoods(currentpage);
		//总页数
		int totalpage = service.findTotalPage();
//		System.out.println(totalpage);
//		for (GoodsPO goodsPO : list) {
//			System.out.println(goodsPO.getGimg());
//		}
		//将结果存入map集合
		map.put("list", list);
		map.put("totalpage", totalpage);
		map.put("currentpage", currentpage);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
