package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.service.ShoppingCart;
/**
 * 添加购物车
 * @author Administrator
 *
 */
public class ShoppingCartServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession(true);
		//获取用户姓名
		String name = (String) session.getAttribute("accountname");
		//获取用户id
		int uid = (int) session.getAttribute("uid");
		//获取商品id
		String gid = request.getParameter("gid");
		//获取加入商品
		String buynum = request.getParameter("buynum");
		
		//System.out.println(uid);
		//System.out.println(name);
		int re = new ShoppingCart().addGoods(uid,gid,buynum);
		
		ObjectMapper om = new ObjectMapper();
		Map<String,Object> map = new HashMap<String, Object>();		
		//0：添加商品数量不能零 1：添加数量大于库存数 2：添加成功
		if(re==0){
			map.put("mes", "添加数量不能为零");
		}else if(re == 1) {
			map.put("mes", "添加购物车失败,库存不够");
		}else if (re == 2) {
			map.put("mes", "添加购物车成功");
		}
		
		om.writeValue(response.getOutputStream(), map);
	}

}
