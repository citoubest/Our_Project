package com.thosepeople.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.StaticsDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.model.StaticsInfo;

public class StaticsDaoImpl extends JdbcDaoSupport implements StaticsDao {

	private static final BeanPropertyRowMapper<StaticsInfo> rowMapper = new BeanPropertyRowMapper<StaticsInfo>(StaticsInfo.class);
	static
	{
		rowMapper.setPrimitivesDefaultedForNullValue(true);
	}
	
	private static final String INFO_UPDATE_PRE ="INSERT into info_statics(infoId,";
	private static final String INFO_UPDATE_MID=",infoType) values (?,1,?) ON DUPLICATE KEY UPDATE ";

	private static final String USER_UPDATE_PRE="INSERT into  user_statics(uid,";
	private static final String USER_UPDATE_MID=",collects,comments,infoType) values (?,?,'','',?) ON DUPLICATE KEY UPDATE "; 

	
	@Override
	public boolean add(int uid, int infoId,int infotype,String operate) throws BusinessException
	{
		//1.判断是否操作过（赞过，收藏过，评论过）
		//2.更新文章信息
		//3.更新用户信息
		//如果没有操作过，则执行
		if(!isIn(uid,infoId,infotype,operate))//没操作过
		{
			
			
			//更新文章统计信息
			String sql_info = INFO_UPDATE_PRE + operate+INFO_UPDATE_MID+operate+"="+operate+"+1";
			System.out.println(sql_info);
			int info_Cnt= this.getJdbcTemplate().update(sql_info,new Object[]{infoId,infotype});

			//更新用户统计信息			
			String sql_user = USER_UPDATE_PRE+operate+USER_UPDATE_MID+operate+"=concat("+operate+",',',?)";
			int usr_Cnt = this.getJdbcTemplate().update(sql_user,new Object[]{uid,String.valueOf(infoId),infotype,String.valueOf(infoId)});

			//insert return 1 and update return 2
			if(info_Cnt==2 && usr_Cnt==2 ||info_Cnt==1 && usr_Cnt==1 ||info_Cnt==1 && usr_Cnt==2 ||info_Cnt==2 && usr_Cnt==1)
			{
				return true;
			}
			else
			{
				throw new BusinessException("点赞数据库操作出错");
			}
		}
		else
		{
			throw new BusinessException("用户已经做过该操作");
		}
	}

	private static final String USER_EXIT = "select count(*) from user_statics where uid=?";

	@SuppressWarnings("deprecation")
	@Override
	public boolean minus(int uid, int infoId,int infotype,String operate) throws BusinessException
	{
		//更新用户信息
		//1. 根据uid 查找是否已经存在
		int usrCnt=this.getJdbcTemplate().queryForInt(USER_EXIT, new Object[]{uid});
		//不存在，说明之前就没操作过，存在错误
		if(usrCnt==0)
		{
			throw new BusinessException("该用户之前没有对该信息进行加的操作:用户ID"+uid+"文章id:"+infoId+"文章类型:"+infoId+"操作:"+operate);
		}
		else
		{
			//查出来
			String selectOldSQL = "select "+operate+ " from user_statics where uid=?";
			String old_likes =(String)this.getJdbcTemplate().queryForObject(selectOldSQL, new Object[]{uid},String.class);
			//如果为空说明，之前没做过
			if(old_likes==null ||old_likes=="")
			{
				throw new BusinessException("该用户之前没有对该信息进行加的操作:用户ID"+uid+"文章id:"+infoId+"文章类型:"+infoId+"操作:"+operate);
			}
			
			List<String>old_list =Arrays.asList(old_likes.split(","));
			Iterator<String> it = old_list.iterator();
			String cur_infoId = String.valueOf(infoId);
			it = old_list.iterator();
			boolean flag = false;
			for (String string : old_list) {
				if(cur_infoId.equals(string))
				{
					it.remove();
					flag = true;
					break;
				}
			}

			if(!flag)
			{
				throw new BusinessException("该用户之前没有对该信息进行加的操作:用户ID"+uid+"文章id:"+infoId+"文章类型:"+infoId+"操作:"+operate);
			}

			//如果只有一项
			StringBuilder builder = new StringBuilder();
			for (String string : old_list) {
				builder.append(string).append(",");
			}
			builder.deleteCharAt(builder.lastIndexOf(","));
			String new_value = builder.toString();
			
			String updateSQl ="update user_statics set "+operate+"=? where uid=?";
			int usr_Cnt=this.getJdbcTemplate().update(updateSQl, new Object[]{new_value,uid});

			
			//更新文章信息,将对应字段减一
			String sql_info = INFO_UPDATE_PRE + operate+INFO_UPDATE_MID+operate+"="+operate+"-1";
			int info_Cnt= this.getJdbcTemplate().update(sql_info,new Object[]{infoId,infotype});

			
			if(usr_Cnt>0 && info_Cnt>0)
			{
				return true;
			}
			else
			{
				throw new BusinessException("数据库更新错误"+uid+"文章id:"+infoId+"文章类型:"+infoId+"操作:"+operate);
			}

		}

	}

	private static String isLiked="select count(*) from user_statics where uid=?  and infoType=? and FIND_IN_SET(?,";	
	// adjust the user has like the article,if liked return true, else false
	@SuppressWarnings("deprecation")
	private boolean isIn(int uid,int infoId,int infoType,String operate)
	{
		boolean isIn=false;
		String sql="";
		switch(operate)
		{
		case "likes":
			sql=isLiked+"likes)";
			break;
		case "collects":
			break;
		default:
			break;
		}
		int cnt = this.getJdbcTemplate().queryForInt(sql,new Object[]{uid,infoType,infoId});

		if(cnt==1)
		{
			isIn = true;
		}
		return isIn;
	}
	
	
	private static final String GET_USR_STATICS_INFO = "select us.infotype,us.likes,us.collects,us.collects from user_statics us where uid=?";
	public Map<Integer,StaticsInfo> getStaticsInfoByUid(int uid)
	{
		List<StaticsInfo> result =this.getJdbcTemplate().query(GET_USR_STATICS_INFO,new Object[]{uid},rowMapper);
		Map<Integer,StaticsInfo> map= new HashMap<Integer,StaticsInfo>(3);
		
		for (StaticsInfo staticsInfo : result) {
			map.put(staticsInfo.getInfotype(), staticsInfo);
		}
		return map;
	}
}
