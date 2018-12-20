package com.woniuxy.shop.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.woniuxy.shop.dao.UsersDAO;
import com.woniuxy.shop.tools.MD5_Encoding;
/**
 * 注册信息逻辑处理
 * @author Administrator
 *
 */
public class RegisteredService {

	public int addUser(String name, String pass, String pass1, String code,
			String realcode) {
		// 0：验证码错误 1：用户名格式不正确 2：密码格式不正确 3：两次密码不一致 4：用户名已存在 5:注册成功
		int re = 0;
		//验证码验证
		if (!code.equals(realcode)) {
			return re;

		}
		// 正则表达式判断用户名
		Pattern patternname = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{1,15}");
		Matcher matchername = patternname.matcher(name);
		boolean blname = matchername.matches();
		//用户名不合法
		if (!blname) {
			re = 1;
			return re;
		}
		// 正则表达式判断密码
		Pattern patternpass = Pattern.compile("[a-zA-Z0-9]{6,16}");
		Matcher matcherpass = patternpass.matcher(pass);
		boolean blpass = matcherpass.matches();
		//密码不合法
		if(!blpass){
			re = 2;
			return re;
		}
		//两次密码不一致
		if(!pass.equals(pass1)){
			re = 3;
			return re;
		}
		//判断用户名是否已近注册
		if(new UsersDAO().findPassByName(name).length()>0){
			re = 4;
			return re;
		}
		//将pass转化为md5格式
		String md5pass = new MD5_Encoding().getMD5ofStr(pass);
		//注册成功，添加用户姓名和密码
		boolean bl = new UsersDAO().addUser(name,md5pass);
		if(bl){
			//输入用户姓名，返回用户id
			int id = new UsersDAO().findId(name);
			//传入用户id，添加用户的余额
			new UsersDAO().addUserInfo(id);
			re = 5;
			return re;
		}
		return re;
	}

}
