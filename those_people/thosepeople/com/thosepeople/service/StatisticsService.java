package com.thosepeople.service;

import com.thosepeople.constant.InfoType;
import com.thosepeople.exception.BusinessException;


public interface StatisticsService {

	boolean postLike(int uid,int infoId,InfoType infoTYpe)  throws BusinessException;
	boolean postUnLike(int uid,int infoId,InfoType infoTYpe)  throws BusinessException;
	
	boolean collect(int uid, int infoId,InfoType infoTYpe);
	
	boolean addVisitCount(int id,int infoId,InfoType infoTYpe);
	int getVisitCount(int id, int infoId,InfoType infoTYpe);
}
