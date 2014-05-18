package com.thosepeople.dao.impl;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.VisitDao;

/**
 * 
 * @author xuyingjie
 *
 */
public class VisitDaoImpl  extends JdbcDaoSupport implements VisitDao {
	

	@Override
	public boolean addVisitCount(int id, int infoId,InfoType infotype) {

		return false;
	}

	@Override
	public int getVisitCount(int id,int infoId,InfoType infotype) {
		
		return -1;
	}
	
	
}
