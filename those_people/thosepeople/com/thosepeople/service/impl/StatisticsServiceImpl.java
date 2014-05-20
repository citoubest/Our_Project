package com.thosepeople.service.impl;


import java.util.Map;

import com.thosepeople.dao.StaticsDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.StaticsInfo;
import com.thosepeople.service.StatisticsService;

public class StatisticsServiceImpl  implements StatisticsService{


	private StaticsDao staticsDao;

	

	public void setStaticsDao(StaticsDao staticsDao) {
		this.staticsDao = staticsDao;
	}
	@Override
	public boolean add(int uid, int infoId, int infotype,
			String operate) throws BusinessException {
		
		boolean flag =staticsDao.add(uid, infoId, infotype, operate);
		return flag;
	}
	@Override
	public boolean minus(int uid, int infoId, int infotype,
			String operate) throws BusinessException {
		boolean flag =staticsDao.minus(uid, infoId, infotype, operate);
		return flag;
	}
	@Override
	public Map<Integer,StaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException
	{
		return staticsDao.getStaticsInfoByUid(uid);
	}
}
