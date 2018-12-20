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
import com.woniuxy.shop.dao.po.UserInfoPO;
import com.woniuxy.shop.service.TopService;
/**
 * 导航栏信息展示
 * @author Administrator
 *
 */
public class TopServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession(true);
		//获取用户姓名
		String name = (String) session.getAttribute("accountname");
		//获取用户的id
		int uid = (int) session.getAttribute("uid");
		//存储用户信息
		List<UserInfoPO> list = null;
		list = new TopService().findBalance(uid);
		Map<String,Object> map = new HashMap<String,Object>();
		//将结果存入map集合
		map.put("accountname", name);
		map.put("list", list);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
