package com.woniuxy.shop.servlet;
/**
 * 注销功能
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogOutServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession();
		//结束session
		session.invalidate();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("res", "success");
//		String uid = (String) session.getAttribute("uid");
//		System.out.println("uid"+uid);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), "map");
		
	}

}
