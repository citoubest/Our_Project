package com.thosepeople.dao;

import com.thosepeople.constant.InfoType;

/**
 * 
 * @author xuyingjie
 *
 */


public interface VisitDao {
	boolean addVisitCount(int id,int infoId,InfoType it);
	int getVisitCount(int id,int infoId,InfoType it);
}
