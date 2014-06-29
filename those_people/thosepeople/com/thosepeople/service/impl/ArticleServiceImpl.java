package com.thosepeople.service.impl;

import com.thosepeople.dao.ArticleDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.po.ArticleInfo;
import com.thosepeople.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

	
	ArticleDao articleDao;

	public ArticleDao getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	
	@Override
	public boolean postArticle(ArticleInfo articleInfo)throws BusinessException
	{
		return articleDao.postArticle(articleInfo);
	}
}
