package com.woniuxy.shop.servlet;
/**
 * 登陆功能
 * 根据用户姓名查找密码，密码长度小于等于0，用户名不存在
 */
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

import org.apache.tomcat.jni.User;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.service.LoginService;

public class LoginServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得用户名
		String username = request.getParameter("username");
		//取得密码
		String pass = request.getParameter("pass");
		//取得输入的验证码
		String code = request.getParameter("code");
		//取出图片上的验证码
		//System.out.println(pass);
		HttpSession session = request.getSession(true);
		String realcode = (String)session.getAttribute("randCheckCode");
	//	System.out.println(username+pass+code+realcode);
		//传入用户输入数据，返回一个int类型
		int re = new LoginService().checkLogin(username,pass,code,realcode);
		
		ObjectMapper om = new ObjectMapper();
		//定义map集合
		Map<String,Object> map = new HashMap<String,Object>();
		//0:账户不存在 1：密码错误 2：验证码错误 3：登陆成功
		if(re == 0){
			map.put("mes", "用户名不存在");
		}else if (re == 1) {
			map.put("mes", "密码错误");
		}else if (re == 2) {
			map.put("mes", "验证码错误");
		}else if (re == 3) {
			//根据用户姓名查找用户id
			int id = new LoginService().findIdByName(username);
			//将id存入到session中
			session.setAttribute("uid", id);
			//将用户姓名存入到session中
			session.setAttribute("accountname", username);
			map.put("mes", "success");
		}
		om.writeValue(response.getOutputStream(), map);
		
	}

}
