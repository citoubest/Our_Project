package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.CollectDao;

public class CollectDaoImpl extends JdbcDaoSupport  implements CollectDao{

	@Override
	public boolean collect(int uid, int infoId,InfoType infotype) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean getAllCollectById(int uid,InfoType infotype) {
		// TODO Auto-generated method stub
		return true;
	}
}
