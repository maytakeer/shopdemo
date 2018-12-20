package com.woniuxy.shop.servlet;
/**
 * 发送邮件信息
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.shop.dao.po.UserInfoPO;
import com.woniuxy.shop.service.ShowUserInfoService;
import com.woniuxy.shop.tools.SendMail;

public class SendEmailServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//取得邮箱表中的id
		String eid = request.getParameter("eid");
		System.out.println(eid);
		//定义一个list集合，用于保存邮箱表中的信息
		List<UserInfoPO> list = null;
		//根据id查找信息
		list = new ShowUserInfoService().findInfoByEid(eid);
		//发送的邮箱地址
		String receiver = "";
		//邮件主题
		String title = "欢迎光临XX小店";
		//邮件内容
		String content = "";
		//遍历获取list集合中的值
		for (UserInfoPO userInfoPO : list) {
			//获取邮箱地址
			receiver = userInfoPO.getMail();
			//获取邮箱内容
			content = "地址："+userInfoPO.getAddress()+"电话："+userInfoPO.getPhone()+"姓名："+userInfoPO.getRealname();
		}
		try {
			//发送邮箱
			new SendMail().send(receiver, title, content);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("res", "success");
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
