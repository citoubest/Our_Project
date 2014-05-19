package com.thosepeople.dao;

import com.thosepeople.constant.InfoType;
import com.thosepeople.exception.BusinessException;

public interface LikeDao {

	boolean postLike(int uid, int infoId,InfoType infotype) throws BusinessException;
	boolean postUnLike(int uid, int infoId,InfoType infotype) throws BusinessException;
	
	boolean getAllLikeById(int uid,InfoType infotype)throws BusinessException;
}
