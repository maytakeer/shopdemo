package com.woniuxy.shop.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class ReplaceCheckListener implements HttpSessionAttributeListener {
	//存session --->key:账号，value:session
	Map<String,HttpSession> map = new HashMap<String,HttpSession>();
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		//取得当前session
		HttpSession session = arg0.getSession();
		//取出当前账号
		Object object = session.getAttribute("accountname");
		System.out.println("------------------------");
		if(object!=null){
			String name = (String)object;
			//查看map中是否有该对象的信息
			HttpSession oldsession = map.get(name);
			//如果有说明登陆了
			if(oldsession!=null){
				System.out.println("old:"+oldsession.getId());
				System.out.println("new:"+session.getId());
				//判断当前session是否与旧的session是同一个
				if(!oldsession.getId().equals(session.getId())){
					//重复登陆的情况，上一个登陆的状态切回到未登录
					oldsession.removeAttribute("accountname");
				}
			}
			//如果没有，是第一次登陆
			map.put(name, session);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {

	}

}
