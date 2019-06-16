package com.bigfong.cloud.servicedemo.service.basic;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicedemo.entity.basic.Article;


public interface IArticleService extends IService<Article> {

    Article getArticleById(Article article);
}
