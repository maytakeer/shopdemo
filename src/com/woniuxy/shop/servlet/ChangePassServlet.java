package com.woniuxy.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.service.ChangePassService;
/**
 * 根据用户名和旧密码修改用户密码
 * @author Administrator
 *
 */
public class ChangePassServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//用户名
		String username = request.getParameter("username");
		//旧密码
		String pass = request.getParameter("pass");
		//新密码
		String pass1 = request.getParameter("pass1");
		//第二次输入的新密码
		String pass2 = request.getParameter("pass2");
		//System.out.println(pass1+" "+pass2);
		// 0：两次密码不一致 1：新密码格式不正确 2：用户名不存在 3：旧密码错误 4：修改密码成功
		int re = new ChangePassService().checkPass(username,pass,pass1,pass2);
		
		ObjectMapper om = new ObjectMapper();
		//定义map集合
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(re == 0){
			map.put("mes", "两次密码不一致");
		}
		if(re == 1){
			map.put("mes", "新密码格式不正确");
		}
		if(re == 2){
			map.put("mes", "用户名不存在");
		}
		if(re == 3){
			map.put("mes", "旧密码错误");
		}
		if(re == 4){
			map.put("mes", "修改密码成功");
			map.put("res", "success");
		}
		//将map已流的形式写入到data
		om.writeValue(response.getOutputStream(), map);
	}

}
