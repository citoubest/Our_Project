package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.JobDao;
import com.thosepeople.po.JobInfo;
import com.thosepeople.vo.JobDetailInfo;
import com.thosepeople.vo.InfoProfile;


/**
 * 
 * @author xuyingjie
 *
 */

public class JobDaoImpl extends JdbcDaoSupport implements JobDao{


	private static final BeanPropertyRowMapper<InfoProfile> rowMapper = new BeanPropertyRowMapper<InfoProfile>(InfoProfile.class);
	private static final BeanPropertyRowMapper<JobDetailInfo> detailRowMapper = new BeanPropertyRowMapper<JobDetailInfo>(JobDetailInfo.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
		detailRowMapper.setPrimitivesDefaultedForNullValue(true);
	}

	private static final String INSERT_JOB_INFO="insert into job_info(uid,title,workplace,jobtype,postdate,company,content,requires,email,tel) "
			+ "value(?,?,?,?,?,?,?,?,?,?)";


	@Override
	public boolean postJobInfo(final JobInfo job)
	{

		int result=this.getJdbcTemplate().update(INSERT_JOB_INFO, job.toStrArray());

		if(result ==1)
		{
			return true;
		}
		return false;
	}

	private static final String LOAD_JOB_INFO = "select j.id, j.title,j.workplace,j.jobtype,j.postdate,u.nickName,u_d.headPicPath from job_info j,user u,user_detail u_d where j.uid=u.id and j.uid=u_d.uid "
			+ "order by j.postdate desc limit 0,10";

	
	
	public List<InfoProfile> getMoreInfo(String keyword, int pageNum,int pageSize) {
		
		List<InfoProfile> list = new ArrayList<InfoProfile>(10);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(LOAD_JOB_INFO,rowMapper);
		}
		return list;
	}

	
	private static final String LOAD_JOB_DETAIL_INFO ="select j.*, s.* ,u.nickName,u_d.headPicPath from job_info j,user u,info_statics s,user_detail u_d where j.id=? and j.uid=u.id and j.id=s.infoId and j.uid=u_d.uid";

	@Override
	public JobDetailInfo loadJobDetailInfo(int jid) {
		
		//TODO:  increase the count of info visitors 
		List<JobDetailInfo> result =this.getJdbcTemplate().query(LOAD_JOB_DETAIL_INFO,new Object[]{jid},detailRowMapper);
		{
			if(!CollectionUtils.isEmpty(result))
			{
				return result.get(0);
			}
		}
		return null;
	
	}
}
