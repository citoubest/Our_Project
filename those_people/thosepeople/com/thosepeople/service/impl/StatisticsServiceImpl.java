package com.thosepeople.service.impl;


import java.util.Map;

import com.thosepeople.constant.OperateType;
import com.thosepeople.dao.StaticsDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.UserStaticsInfo;
import com.thosepeople.service.StatisticsService;

/**
 * 
 * @author xuyingjie
 *
 */
public class StatisticsServiceImpl  implements StatisticsService{


	private StaticsDao staticsDao;

	public void setStaticsDao(StaticsDao staticsDao) {
		this.staticsDao = staticsDao;
	}
	// called when user push like or collect
	@Override
	public boolean add(int uid, int infoId, int infotype,
			OperateType operate) throws BusinessException {
		
		boolean flag =staticsDao.add(uid, infoId, infotype, operate);
		return flag;
	}
	// called when user push unlike or uncollect
	@Override
	public boolean minus(int uid, int infoId, int infotype,
			OperateType operate) throws BusinessException {
		boolean flag =staticsDao.minus(uid, infoId, infotype, operate);
		return flag;
	}
	
	@Override
	public Map<Integer,UserStaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException
	{
		return staticsDao.getStaticsInfoByUid(uid);
	}
}
