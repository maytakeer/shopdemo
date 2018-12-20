package com.woniuxy.shop.Filter;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionFilter implements Filter {

	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//获取当前url
		String url = request.getRequestURL().toString();
		//设置拦截的url
		if(url.endsWith("changepass.jsp")||url.endsWith("order.jsp")||url.endsWith("shopcart.jsp")
				||url.endsWith("showgoods.jsp")||url.endsWith("showgoodsinfo.jsp")||url.endsWith("showuserinfo.jsp")
				||url.endsWith("test1.jsp")||url.endsWith("top.jsp")||url.endsWith("userinfo.jsp")){
			
			//获取当前session
			HttpSession session = request.getSession();
			//取得session中的用户姓名
			Object name = session.getAttribute("accountname");
			System.out.println("name"+name);
			//session中没有存入用户姓名
			if(name == null){
				//请求转发到登陆页面
				response.sendRedirect("login.jsp");
				return;
			}
			//放行
			arg2.doFilter(arg0, arg1);
			return;
		}else{
			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
