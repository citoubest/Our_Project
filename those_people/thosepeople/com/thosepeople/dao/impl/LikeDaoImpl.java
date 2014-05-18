package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.LikeDao;

public class LikeDaoImpl extends JdbcDaoSupport implements LikeDao {
	
	// post like sql

	
	
	private static final String USER_EXITS ="select count(*) from user_statics where uid=?";
	private static final String INFO_EXITS = "select count(*) from info_statics where infoId=? and infoType =?";

	
	@Override
	public boolean postLike(int uid, int infoId,InfoType infotype) {
		
		boolean flag=false;
		switch(infotype)
		{
			case JOB_INFO:
				flag=add(uid,infoId,infotype,"like");
				break;
			case HOUSE_INFO:
				
				break;
			case LOVE_INFO:
				
				break;
			case ACTIVITY_INFO:
				
				break;
		}
	
		return flag;
	}
	
	@Override
	public boolean postUnLike(int uid, int infoId,InfoType infotype) {

		return true;
	}
	
	@Override
	public boolean getAllLikeById(int uid,InfoType infotype) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	@SuppressWarnings("deprecation")
	private boolean add(int uid, int infoId,InfoType infotype,String property)
	{
		//1. 根据uid 查找是否已经存在
		int usrCnt=this.getJdbcTemplate().queryForInt(USER_EXITS, new Object[]{uid});
		//2.根据info_id 查看是否存在
		int info_Cnt = this.getJdbcTemplate().queryForInt(INFO_EXITS,new Object[]{infoId,infotype});
		//3. 存在则update,否则insert 
		String updateSQl;
		int flag_usr=0;
		int flag_info=0;
		if(usrCnt==0)
		{
			updateSQl ="insert into user_statics(uid,job_likes)values(?,?)";
			flag_usr=this.getJdbcTemplate().update(updateSQl, new Object[]{uid,infoId});
			
		}
		else
		{
			String selectOldSQL = "select job_likes from user_statics where uid=?";
			String old_likes =(String)this.getJdbcTemplate().queryForObject(selectOldSQL, new Object[]{uid,infoId},String.class);
			String new_likes = old_likes+"|"+infoId;
			updateSQl ="update user_statics set job_likes=? where uid=?";
			flag_usr =this.getJdbcTemplate().update(selectOldSQL, new Object[]{new_likes,uid});
		}
		
		if(info_Cnt==0)
		{
			updateSQl ="insert into info_statics(infoId,likes,infoType) values(?,?,?)";
			flag_info=this.getJdbcTemplate().update(updateSQl, new Object[]{infoId,1,infotype});
		}
		else
		{
			updateSQl = "update info_statics set likes = likes+1 where infoId= ? and infoType=?";
			flag_info=this.getJdbcTemplate().update(updateSQl, new Object[]{infoId,infotype});
		}
		
		if(flag_usr==1 && flag_info==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
