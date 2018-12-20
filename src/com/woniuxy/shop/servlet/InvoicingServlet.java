package com.woniuxy.shop.servlet;
/**
 * 结账功能
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
import com.woniuxy.shop.service.InvoicingService;

public class InvoicingServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//打开session
		HttpSession session = request.getSession(true);
		//取得session中的uid
		int uid = (int)session.getAttribute("uid");
		//执行支付 返回一个int类型1：库存不够 2：余额不够 3：执行成功
		int re = new InvoicingService().payByUid(uid);
		
		Map<String,Object> map = new HashMap<String,Object>();
	//	System.out.println(re);
		if(re==1){
			map.put("mes", "库存不够");
		}
		if(re==2){
			map.put("mes", "余额不够");
		}
		if(re==3){
			map.put("mes", "结账成功");
			map.put("res", "success");
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
