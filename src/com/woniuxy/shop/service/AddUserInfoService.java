package com.woniuxy.shop.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.woniuxy.shop.dao.UserInfoDAO;
import com.woniuxy.shop.dto.UserInfoDTO;
/**
 * 添加用户邮寄信息
 * @author Administrator
 *
 */
public class AddUserInfoService {

	public int addUserInfo(UserInfoDTO dto) {
		// 0:插入失败 1：电话号码不正确 :2：邮箱不正确 3：插入成功
		int re = 0;
		// 正则表达式判断电话号码1
		Pattern patternphone = Pattern
				.compile("^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcherphone = patternphone.matcher(dto.getPhone());
		boolean blphone = matcherphone.matches();
		//不符合电话号码格式
		if (!blphone) {
			re = 1;
			return re;
		}
		// 正则表达式判断邮箱2
		boolean blemail = Pattern
				.compile(
						"^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")
				.matcher(dto.getEmail()).matches();
		//不符合邮箱格式
		if (!blemail) {
			re = 2;
			return re;
		}
		//添加用户邮寄的地址
		boolean bl = new UserInfoDAO().addUserInfoById(dto);
		// 插入数据成功
		if (bl) {
			re = 3;
			return re;
		}

		return re;
	}

}
