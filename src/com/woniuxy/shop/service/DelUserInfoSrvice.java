package com.woniuxy.shop.service;

import com.woniuxy.shop.dao.UserInfoDAO;
/**
 * 
 * @author Administrator
 *删除邮寄地址
 */
public class DelUserInfoSrvice {
	
	public void delUserInfo(String id) {
		//邮寄地址的id
		int eid = 0;
		//将邮寄地址的id转为int类型，并做异常处理
		try {
			eid = Integer.parseInt(id);
		} catch (Exception e) {
			
		}
		//传入id，删除邮寄地址信息
		new UserInfoDAO().delUserInfoById(eid);
	}

}
