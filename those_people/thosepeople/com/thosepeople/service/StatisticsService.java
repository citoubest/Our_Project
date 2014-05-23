package com.thosepeople.service;


import java.util.Map;

import com.thosepeople.constant.OperateType;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.UserStaticsInfo;


public interface StatisticsService {

	boolean add(int uid,int infoId,int infotype,OperateType operate)  throws BusinessException;
	boolean minus(int uid,int infoId,int infotype,OperateType operate)  throws BusinessException;
	Map<Integer,UserStaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException;
}
