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
import com.woniuxy.shop.service.DelectCartGoodsService;
/**
 * 多余的
 * @author Administrator
 *
 */
public class DelectCartGoodsServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession();
//		int uid = (int) session.getAttribute("uid");
		//取得购物车id
		String cid = request.getParameter("cid");
		
		//System.out.println("cid:"+cid);
		boolean bl = new DelectCartGoodsService().delCartGoodByCid(cid);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(bl){
			map.put("mes", "删除成功");
		}else{
			map.put("mes", "删除失败");
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
