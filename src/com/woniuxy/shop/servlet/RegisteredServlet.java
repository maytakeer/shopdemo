package com.woniuxy.shop.servlet;
/**
 * 注册功能
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
import com.woniuxy.shop.service.RegisteredService;

public class RegisteredServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//取出用户提交的数据信息
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String pass1 = request.getParameter("pass1");
		String code = request.getParameter("code");
		
		//取出session中的验证码
		HttpSession session = request.getSession(true);
		String realcode = (String) session.getAttribute("randCheckCode");
		
		// 0：验证码错误 1：用户名格式不正确 2：密码格式不正确 3：两次密码不一致 4：用户名已存在 5:注册成功
		int re = new RegisteredService().addUser(name,pass,pass1,code,realcode);
		
		ObjectMapper om = new ObjectMapper();
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(re == 0){
			map.put("mes", "验证码错误");
		}
		if(re == 1){
			map.put("mes", "用户名为1到15位数字和字母");
		}
		if(re == 2){
			map.put("mes", "密码为6到16位的数字和密码");
		}
		if(re == 3){
			map.put("mes", "两次密码不一致");
		}
		if(re == 4){
			map.put("mes", "用户名已存在");
		}
		if(re == 5){
			map.put("mes", "注册成功");
			map.put("state", "success");
		}
		om.writeValue(response.getOutputStream(), map);
	}

}
