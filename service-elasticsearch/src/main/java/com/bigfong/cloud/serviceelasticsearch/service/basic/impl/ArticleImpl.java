package com.bigfong.cloud.serviceelasticsearch.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.serviceelasticsearch.entity.basic.Article;
import com.bigfong.cloud.serviceelasticsearch.mapper.basic.ArticleMapper;
import com.bigfong.cloud.serviceelasticsearch.service.basic.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ArticleImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    private static Logger logger = LoggerFactory.getLogger(ArticleImpl.class);

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public Article getArticleById(Article article) {
        return articleMapper.getArticleById(article);
    }
}
