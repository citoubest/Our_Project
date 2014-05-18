package com.thosepeople.dao;

import com.thosepeople.constant.InfoType;

public interface CollectDao {

	boolean collect(int uid,int infoId,InfoType infotype);
	boolean getAllCollectById(int uid,InfoType infotype);
}
