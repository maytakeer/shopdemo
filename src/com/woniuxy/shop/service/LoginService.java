package com.woniuxy.shop.service;

import com.woniuxy.shop.dao.UsersDAO;
import com.woniuxy.shop.tools.MD5_Encoding;
/**
 * 登陆功能逻辑处理
 * @author Administrator
 *
 */
public class LoginService {
	/*
	 * 登陆数据检查
	 */
	public int checkLogin(String username, String pass, String code, String realcode) {
		//0:账户不存在 1：密码错误 2：验证码错误 3：登陆成功
		int re = 0;
		UsersDAO dao = new UsersDAO();
		//传入用户姓名，返回密码
		String realpass = dao.findPassByName(username);
		//验证码判断不区分大小写
		if(!code.equalsIgnoreCase(realcode)){
			re = 2;
			return re;
		}
		//返回密码长度判断，小于0说明用户不存在
		if(realpass.length()<=0){
			return re;
		}
		MD5_Encoding md5 = new MD5_Encoding();
		System.out.println(md5.getMD5ofStr(pass));
		System.out.println(realpass);
		//输入密码是否与数据库的密码一致
		if(md5.getMD5ofStr(pass).equals(realpass)){
			re = 3;
			return re;
		}else {
			re = 1;
			return re;
		}
	}
	/*
	 * 传入用户姓名查找用户id
	 */
	public int findIdByName(String username) {
		//用户id
		int id = 0;
		id = new UsersDAO().findId(username);
		return id;
	}

}
