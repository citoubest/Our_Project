package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.PageDao;
import com.thosepeople.vo.InfoProfile;


/**
 * 
 * @author xuyingjie
 *
 */


public class PageDaoImpl extends JdbcDaoSupport implements PageDao{

	private int pageSize = 10;

	private static final BeanPropertyRowMapper<InfoProfile> rowMapper = new BeanPropertyRowMapper<InfoProfile>(InfoProfile.class);
	private static final String LOAD_JOB_INFO = "select j.id, j.title,j.workplace,j.jobtype, LEFT(content,100) as content,j.company,j.postdate,u.nickName,u_d.headPicPath from job_info j,user u,user_detail u_d where j.uid=u.id and j.uid=u_d.uid "
			+ "order by j.postdate desc limit ?,?";
	
	private static final String LOAD_LOVE_INFO ="";
	private static final String LOAD_HOUSE_INFO =" select h.id,h.title,h.infoType,h.houseType,h.postTime,u.nickName,u_d.headPicPath from house_info h, user u,user_detail u_d where h.uid=u.id and h.uid=u_d.uid "
			+ "order by h.postTime desc limit ?,?";
	private static final String LOAD_ACTIVITY_INFO ="";
	
	private static final String select_count_sql = " select count(*) from ";	
	
	private static final String LOVE_INFO_TABLE = "love_info";
	private static final String JOB_INFO_TABLE = "job_info";
	private static final String HOUSE_INFO_TABLE = "house_info";
	private static final String ACTIVITY_INFO_TABLE = "activity_info";
	
	@Override
	public int getPageCount(String keyword,InfoType it)
	{
		String count_sql=null;
		switch(it)
		{
		case JOB_INFO:
			count_sql = select_count_sql + JOB_INFO_TABLE;
			break;
		case LOVE_INFO:
			count_sql = select_count_sql + LOVE_INFO_TABLE;
			break;
		case HOUSE_INFO:
			count_sql = select_count_sql + HOUSE_INFO_TABLE;
			break;
		case ACTIVITY_INFO:
			count_sql = select_count_sql + ACTIVITY_INFO_TABLE;
		default:
			return 0;
		}
		return getInfoCount(count_sql)/pageSize;
	}
	
	public List<InfoProfile> getMoreInfo(String keyword, int pageNum,InfoType it) {

		String select_info_sql=null;
		switch(it)
		{
		case JOB_INFO:
			select_info_sql = LOAD_JOB_INFO;
			break;
		case LOVE_INFO:
			select_info_sql = LOAD_LOVE_INFO;
			break;
		case HOUSE_INFO:
			select_info_sql = LOAD_HOUSE_INFO;
			break;
		case ACTIVITY_INFO:
			select_info_sql = LOAD_ACTIVITY_INFO;
		default:
			return null;
		}
		return getMoreJobInfo(keyword,pageNum,pageSize,select_info_sql,select_count_sql);
	}

	
	@SuppressWarnings("deprecation")
	private int getInfoCount(String count_sql)
	{
		return getJdbcTemplate().queryForInt(count_sql);

	}

	private List<InfoProfile> getMoreJobInfo(String keyword ,int pageNum,int pageSize,String sql , String count_sql)
	{
		List<InfoProfile> list = new ArrayList<InfoProfile>(pageSize);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(sql,new Object[]{(pageNum-1)*pageSize,pageSize},rowMapper);
		}
		return list;
	}

	
}
