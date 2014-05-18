package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.LikeDao;

public class LikeDaoImpl extends JdbcDaoSupport implements LikeDao {
	
	// post like sql
	private static final String JOB_INFO_LIKE="insert into";
	private static final String LOVE_INFO_LIKE="";
	private static final String HOUSE_INFO_LIKE="";
	private static final String ACTIVITY_INFO_LIKE="";
	
	private static final String JOB_INFO_UnLIKE="";
	private static final String LOVE_INFO_UnLIKE="";
	private static final String HOUSE_INFO_UnLIKE="";
	private static final String ACTIVITY_INFO_UnLIKE="";
	
	
	private static final String USER_LIKE_JOB_INFO="update user_like set jobs=CONCAT(jobs,'|',?) where uid=?";
	private static final String USER_LIKE_HOUSE_INFO="";
	private static final String USER_LIKE_LOVE_INFO="";
	private static final String USER_LIKE_ACTIVITY_INFO="";


	@Override
	public boolean getAllLikeById(int uid,InfoType infotype) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean postLike(int uid, int infoId,InfoType infotype) {
		
		
		String sql1="";
		String sql2="";
		switch(infotype)
		{
			case JOB_INFO:
				sql1=JOB_INFO_LIKE;
				sql2 =USER_LIKE_JOB_INFO;
				break;
			case HOUSE_INFO:
				sql1 = HOUSE_INFO_LIKE;
				sql2 =USER_LIKE_HOUSE_INFO;
				break;
			case LOVE_INFO:
				sql1 =LOVE_INFO_LIKE;
				sql2 = USER_LIKE_LOVE_INFO;
				break;
			case ACTIVITY_INFO:
				sql1 = ACTIVITY_INFO_LIKE;
				sql2 = USER_LIKE_ACTIVITY_INFO;
				break;
		}
		int count = executeLike(sql1,sql2,uid,infoId);
		if(count==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean postUnLike(int uid, int infoId,InfoType infotype) {
		
		String sql1="";
		switch(infotype)
		{
		case JOB_INFO:
			sql1=JOB_INFO_UnLIKE;
			break;
		case HOUSE_INFO:
			sql1 = HOUSE_INFO_UnLIKE;
			break;
		case LOVE_INFO:
			sql1 =LOVE_INFO_UnLIKE;
			break;
		case ACTIVITY_INFO:
			sql1 = ACTIVITY_INFO_UnLIKE;
			break;
		}
		
		executeUnLike(sql1);
		return true;
	}
	
	
	private int executeLike(String info_sql,String user_sql,int uid,int infoId)
	{
		//1. user_like 
		return 1;
		
	}
	
	private int executeUnLike(String sql)
	{
		
		return 1;
	}
}
