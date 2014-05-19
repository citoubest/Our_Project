package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.LikeDao;
import com.thosepeople.exception.BusinessException;

public class LikeDaoImpl extends JdbcDaoSupport implements LikeDao {

	// post like sql
	private static final String USER_EXIT = "select count(*) from user_statics where uid=?";
	private static final String INFO_UPDATE_PRE ="INSERT into info_statics(infoId,";
	private static final String INFO_UPDATE_MID=",infoType) values (?,1,?) ON DUPLICATE KEY UPDATE ";

	private static final String USER_UPDATE_PRE="INSERT into  user_statics(uid,";
	private static final String USER_UPDATE_MID=") values (?,'1') ON DUPLICATE KEY UPDATE "; 
	
	//判断用户是否已经赞过这篇文章
	//TODO: 1.判断用户是否已经赞过了，2.对于0的情况是不是要删除掉3.
	@Override
	public boolean postLike(int uid, int infoId,InfoType infotype) throws BusinessException{

		String sql_info=INFO_UPDATE_PRE+ "likes"+INFO_UPDATE_MID+"likes=likes+1";
		String sql_user="";
		boolean flag=false;
		switch(infotype)
		{
		case JOB_INFO:
			sql_user =USER_UPDATE_PRE+"job_likes"+USER_UPDATE_MID+" job_likes=concat(job_likes,',',?)";
			flag=add(uid,infoId,infotype,sql_info,sql_user);
			break;
		case HOUSE_INFO:
			sql_user =USER_UPDATE_PRE+"house_likes"+USER_UPDATE_MID+" house_likes=concat(house_likes,',',?)";
			flag=add(uid,infoId,infotype,sql_info,sql_user);
			break;
		case LOVE_INFO:
			sql_user =USER_UPDATE_PRE+"love_likes"+USER_UPDATE_MID+" love_likes=concat(love_likes,',',?)";
			flag=add(uid,infoId,infotype,sql_info,sql_user);
			break;
		case ACTIVITY_INFO:
			sql_user =USER_UPDATE_PRE+"activity_likes"+USER_UPDATE_MID+" activity_likes=concat(activity_likes,',',?)";
			flag=add(uid,infoId,infotype,sql_info,sql_user);
			break;
		}
		return flag;
	}

	@Override
	public boolean postUnLike(int uid, int infoId,InfoType infotype) throws BusinessException{

		String sql_info="update info_statics set likes=likes-1 where infoId=? and infoType= ?";
		boolean flag=minus(uid,infoId,infotype,sql_info);
		return flag;
	}

	@Override
	public boolean getAllLikeById(int uid,InfoType infotype) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean add(int uid, int infoId,InfoType infotype,String sql_info,String sql_user) throws BusinessException
	{
		//更新文章信息
		int info_Cnt =this.getJdbcTemplate().update(sql_info, new Object[]{infoId,infotype.getValue()});
		//更新用户信息
		int info_Usr =this.getJdbcTemplate().update(sql_user, new Object[]{uid,infoId});

		if(info_Cnt==2 && info_Usr==2 ||info_Cnt==1 && info_Usr==1 ||info_Cnt==1 && info_Usr==2 ||info_Cnt==2 && info_Usr==1)
		{
			return true;
		}
		else
		{
			throw new BusinessException("点赞数据库操作出错");
		}
	}

	@SuppressWarnings("deprecation")
	private boolean minus(int uid, int infoId,InfoType infotype,String sql_info) throws BusinessException
	{
		//TODO:有待进一步优化
		//更新文章信息
		int flag_info =this.getJdbcTemplate().update(sql_info, new Object[]{infoId,infotype.getValue()});
		//更新用户信息
		//1. 根据uid 查找是否已经存在
		int usrCnt=this.getJdbcTemplate().queryForInt(USER_EXIT, new Object[]{uid});
		//3. 存在则update,否则insert 
		String updateSQl;
		int flag_usr=0;
		//不存在，则插入数据
		if(usrCnt==0)
		{
			switch(infotype)
			{
			case JOB_INFO:
				updateSQl ="insert into user_statics(uid,job_likes)values(?,?)";
				flag_usr=this.getJdbcTemplate().update(updateSQl, new Object[]{uid,infoId});
				break;
			case HOUSE_INFO:
				updateSQl ="insert into user_statics(uid,house_likes)values(?,?)";
				flag_usr=this.getJdbcTemplate().update(updateSQl, new Object[]{uid,infoId});
				break;
			case LOVE_INFO:
				updateSQl ="insert into user_statics(uid,love_likes)values(?,?)";
				flag_usr=this.getJdbcTemplate().update(updateSQl, new Object[]{uid,infoId});
				break;
			case ACTIVITY_INFO:
				updateSQl ="insert into user_statics(uid,activity_likes)values(?,?)";
				flag_usr=this.getJdbcTemplate().update(updateSQl, new Object[]{uid,infoId});
				break;
			}
		}
		//否则更新数据
		else
		{
			switch(infotype)
			{
			case JOB_INFO:
				String selectOldSQL = "select job_likes from user_statics where uid=?";
				String old_likes =(String)this.getJdbcTemplate().queryForObject(selectOldSQL, new Object[]{uid},String.class);
				int index = old_likes.lastIndexOf(String.valueOf(infoId));
				if(index==-1)
				{
					return false;
				}
				String new_likes = old_likes.substring(0,index-1);
				updateSQl ="update user_statics set job_likes=? where uid=?";
				flag_usr =this.getJdbcTemplate().update(updateSQl, new Object[]{new_likes,uid});
				break;
			case HOUSE_INFO:

				break;
			case LOVE_INFO:
				break;
			case ACTIVITY_INFO:
				break;
			}

		}

		if(flag_info==1 && flag_usr==1)
		{
			return true;
		}
		else
		{
			throw new BusinessException("点赞数据库操作出错");
		}
	}
}
