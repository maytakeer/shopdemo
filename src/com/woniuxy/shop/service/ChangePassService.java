package com.woniuxy.shop.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.woniuxy.shop.dao.UsersDAO;
import com.woniuxy.shop.tools.MD5_Encoding;
/**
 * 
 * @author Administrator
 *	修改密码
 */
public class ChangePassService {

	public int checkPass(String username, String pass, String pass1,
			String pass2) {
		// 0：两次密码不一致 1：新密码格式不正确 2：用户名不存在 3：旧密码错误 4：修改密码成功
		int re = 0;
		//两次输入的密码不一致
		if(!pass1.equals(pass2)){
			return re;
		}
		//正则表达式判断密码格式
		Pattern patternpass = Pattern.compile("[a-zA-Z0-9]{6,16}");
		Matcher matcherpass = patternpass.matcher(pass1);
	//	System.out.println(new MD5_Encoding().getMD5ofStr("qq"));
		boolean blpass = matcherpass.matches();
		//密码格式不正确
		if(!blpass){
			re = 1;
			return re;
		}
		//根据用户姓名查找密码，密码长度小于等于零，用户姓名不存在
		if(new UsersDAO().findPassByName(username).length()<=0){
			re = 2;
			return re;
		}else {
			//将旧密码转化为md5格式
			String md5ofStr = new MD5_Encoding().getMD5ofStr(pass);
			//将新密码转化为md5格式
			String md5ofStr1 = new MD5_Encoding().getMD5ofStr(pass1);
			//判断旧密码是否与数据库中的一样
			if(new UsersDAO().findPassByName(username).equals(md5ofStr)){
				//修改数据库中的密码
				new UsersDAO().changePass(username,md5ofStr1);
				re = 4;
				return re;
			}else {
				re = 3;
				return re;
			}
		}
	}

}
