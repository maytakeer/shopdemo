package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.woniuxy.shop.service.ShowUserInfoService;
/**
 * 邮寄地址展示
 * @author Administrator
 *
 */
public class ShowUserInfoServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession();
		//取得用户的id
		int uid = (int) session.getAttribute("uid");
		//存放邮寄地址信息
		List<UserInfoPO> list = null;
		//根据用户id查找邮寄地址信息
		list = new ShowUserInfoService().findUserInfo(uid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("list", list);
		
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
