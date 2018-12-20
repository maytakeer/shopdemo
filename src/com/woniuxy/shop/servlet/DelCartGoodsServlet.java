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
import com.woniuxy.shop.service.DelectCartGoodsService;
/**
 * 复选框删除购物车中的商品
 * @author Administrator
 *
 */
public class DelCartGoodsServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取选择了要删除的项
		String[] arr = request.getParameterValues("check");
		//根据传入的购物车id数组删除数据
		boolean bl = new DelectCartGoodsService().delCartGoodByCid(arr);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(bl){
			map.put("mes", "删除成功");
		}else{
			map.put("res", "success");
			map.put("mes", "删除失败，不能为空");
		}
		ObjectMapper om = new ObjectMapper();
		om.writeValue(response.getOutputStream(), map);
	}

}
