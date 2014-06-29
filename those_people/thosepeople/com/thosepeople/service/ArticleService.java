package com.thosepeople.service;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.po.ArticleInfo;

public interface ArticleService {

	boolean postArticle(final ArticleInfo articleInfo) throws BusinessException;
}
