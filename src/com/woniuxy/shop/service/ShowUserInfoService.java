package com.woniuxy.shop.service;

import java.util.List;

import com.woniuxy.shop.dao.UserInfoDAO;
import com.woniuxy.shop.dao.po.UserInfoPO;
/**
 * 用户邮寄地址逻辑处理
 * @author Administrator
 *
 */
public class ShowUserInfoService {
	//传入用户id查找用户邮寄地址
	public List<UserInfoPO> findUserInfo(int uid) {
		//用户邮局地址信息
		List<UserInfoPO> list = null;
		list = new UserInfoDAO().findUserInfo(uid);
		return list;
	}
	//传入用户邮寄地址id查找用户邮寄信息
	public List<UserInfoPO> findInfoByEid(String eid) {
		//用户邮寄信息
		List<UserInfoPO> list = null;
		int id = 0;
		//将eid转化成int类型
		try {
			id = Integer.parseInt(eid);
		} catch (Exception e) {
			
		}
		list = new UserInfoDAO().findByEid(id);
		return list;
	}

}
