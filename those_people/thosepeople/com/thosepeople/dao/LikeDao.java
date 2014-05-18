package com.thosepeople.dao;

import com.thosepeople.constant.InfoType;

public interface LikeDao {

	boolean postLike(int uid, int infoId,InfoType infotype);
	boolean postUnLike(int uid, int infoId,InfoType infotype);
	
	boolean getAllLikeById(int uid,InfoType infotype);
}
