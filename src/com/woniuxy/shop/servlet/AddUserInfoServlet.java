package com.woniuxy.shop.servlet;

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
import com.woniuxy.shop.dto.UserInfoDTO;
import com.woniuxy.shop.service.AddUserInfoService;
/**
 * 添加用户详细信息：邮箱，地址，电话，姓名
 * @author Administrator
 *
 */
public class AddUserInfoServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取前端的数据
		String realname = request.getParameter("realname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		//将数据装入UserInfoDTO对象
		UserInfoDTO dto = new UserInfoDTO();
		dto.setAddress(address);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setRealname(realname);
		//打开session
		HttpSession session = request.getSession();
		//取出session中的uid
		int uid = (int) session.getAttribute("uid");
		dto.setUid(uid);
		//向用户信息添加数据
		int re = new AddUserInfoService().addUserInfo(dto);
		
		Map<String,Object> map = new HashMap<String,Object>();
		// 0:插入失败 1：电话号码不正确 :2：邮箱不正确 3：插入成功
		if(re == 0){
			map.put("mes", "插入失败");
		}else if (re == 1) {
			map.put("mes", "电话号码不正确");
		}else if (re == 2) {
			map.put("mes", "邮箱不正确");
		}else if (re == 3) {
			map.put("mes", "插入成功");
			map.put("res", "success");
		}
		//将map写入到前端的data中
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
