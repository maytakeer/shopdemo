package com.woniuxy.shop.service;

import java.util.List;

import com.woniuxy.shop.dao.UserInfoDAO;
import com.woniuxy.shop.dao.po.UserInfoPO;
/**
 * 导航栏逻辑处理
 * @author Administrator
 *
 */
public class TopService {
	
	public List<UserInfoPO> findBalance(int uid) {
		
		List<UserInfoPO> list = null;
		list = new UserInfoDAO().findBalanceBy(uid);
		
		return list;
	}

}
