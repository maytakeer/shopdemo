package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.dao.po.orders_goodsinfoPO;
import com.woniuxy.shop.service.ShowOrderService;
/**
 * 订单信息
 * @author Administrator
 *
 */
public class ShowOrderServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession(true);
		//取得用户的id
		int uid = (int)session.getAttribute("uid");
		//取得用户的姓名
		String name = (String) session.getAttribute("accountname");
		System.out.println(name);
		//存储订单信息
		List<orders_goodsinfoPO> list = null;
		//根据用户id返回订单信息
		list = new ShowOrderService().showOrder(uid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
