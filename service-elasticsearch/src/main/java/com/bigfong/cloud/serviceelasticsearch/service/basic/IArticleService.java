package com.bigfong.cloud.serviceelasticsearch.service.basic;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.serviceelasticsearch.entity.basic.Article;


public interface IArticleService extends IService<Article> {

    Article getArticleById(Article article);
}
