package com.thosepeople.dao;


import java.util.Map;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.StaticsInfo;

public interface StaticsDao {

	boolean add(int uid, int infoId,int infotype,String operate) throws BusinessException;
	boolean minus(int uid, int infoId,int infotype,String operate) throws BusinessException;
	
	Map<Integer,StaticsInfo> getStaticsInfoByUid(int uid)throws BusinessException;
}
