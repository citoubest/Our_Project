package com.thosepeople.dao;


/**
 * 
 * @author xuyingjie
 * 
 */


import java.util.Map;

import com.thosepeople.constant.InfoType;
import com.thosepeople.constant.OperateType;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.StaticsInfo;
import com.thosepeople.model.UserStaticsInfo;

public interface StaticsDao {

	//for like collect 
	boolean add(int uid, int infoId,int infotype,OperateType operate) throws BusinessException;
	boolean minus(int uid, int infoId,int infotype,OperateType operate) throws BusinessException;
	Map<Integer,UserStaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException;
	
	StaticsInfo getStaticsInfoByInfoId(int infoId,InfoType infotype)throws BusinessException;
	boolean addVisit(int infoId,int infoype) throws BusinessException;
}
