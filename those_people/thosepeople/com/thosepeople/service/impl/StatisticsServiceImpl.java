package com.thosepeople.service.impl;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.CollectDao;
import com.thosepeople.dao.LikeDao;
import com.thosepeople.dao.VisitDao;
import com.thosepeople.service.StatisticsService;

public class StatisticsServiceImpl  implements StatisticsService{


	private LikeDao likeDao;
	private CollectDao collectDao;
	private VisitDao visitDao;

	
	public void setLikeDao(LikeDao likeDao) {
		this.likeDao = likeDao;
	}


	public void setCollectDao(CollectDao collectDao) {
		this.collectDao = collectDao;
	}


	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}


	@Override
	public boolean postLike(int uid, int infoId,InfoType infoTYpe) {
		boolean flag = likeDao.postLike(uid, infoId,infoTYpe);
		return flag;
	}


	@Override
	public boolean postUnLike(int uid, int infoId,InfoType infoTYpe) {

		boolean flag =likeDao.postUnLike(uid, infoId, infoTYpe);
		return flag;
	}

	@Override
	public boolean collect(int uid, int infoId,InfoType infoTYpe) {

		boolean flag = collectDao.collect(uid,infoId,infoTYpe);
		return flag;
	}

	@Override
	public boolean addVisitCount(int id, int infoId,InfoType infoTYpe) {
		
		boolean flag =visitDao.addVisitCount(id, infoId,infoTYpe);
		return flag;
	}
	@Override
	public int getVisitCount(int id, int infoId, InfoType infoTYpe) {
		
		int count = visitDao.getVisitCount(id, infoId,infoTYpe);
		return count;
		
	}


}
