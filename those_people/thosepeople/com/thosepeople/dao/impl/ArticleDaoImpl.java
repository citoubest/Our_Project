package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.ArticleDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.po.ArticleInfo;

public class ArticleDaoImpl extends JdbcDaoSupport implements ArticleDao{

	private static final String INSERT_ARTICLE_INFO="insert into article_info(uid,content)"
			+ "value(?,?)";

	@Override
	public boolean postArticle(final ArticleInfo articleInfo)throws BusinessException
	{

		int result=this.getJdbcTemplate().update(INSERT_ARTICLE_INFO, articleInfo.getUid(),articleInfo.getContent());

		if(result ==1)
		{
			return true;
		}
		return false;
	}
	
	
}
