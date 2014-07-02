package com.thosepeople.dao;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.po.ArticleInfo;

public interface ArticleDao {

	boolean postArticle(final ArticleInfo articleInfo)throws BusinessException;
}
