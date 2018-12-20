package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.service.DelUserInfoSrvice;
/**
 * 根据id删除email表中的数据
 * @author Administrator
 *
 */
public class DelUserInfoServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得eid
		String id = request.getParameter("eid");
		//根据id删除用户详细信息
		new DelUserInfoSrvice().delUserInfo(id);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), "aa");
	}

}
