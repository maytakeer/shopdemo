package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.dao.po.Cart_goodsinfoPO;
import com.woniuxy.shop.service.ShowShoppingCartService;
/**
 * 购物车展示
 * @author Administrator
 *
 */
public class ShowShoppingCartServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession(true);
		//获取用户id
		int uid = (int) session.getAttribute("uid");
		ShowShoppingCartService service = new ShowShoppingCartService();
		//购物车商品信息
		List<Cart_goodsinfoPO> list = null;
		//根据用户id查找购物车商品信息
		list = service.findCartInfo(uid); 
		Map<String,Object> map = new HashMap<String,Object>();
		//存入map集合
		map.put("list", list);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
