package com.thosepeople.dao;


import java.util.Map;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.UserStaticsInfo;

public interface StaticsDao {

	boolean add(int uid, int infoId,int infotype,String operate) throws BusinessException;
	boolean minus(int uid, int infoId,int infotype,String operate) throws BusinessException;
	
	Map<Integer,UserStaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException;
}
