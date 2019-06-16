package com.bigfong.cloud.servicerabbitmq.service.basic;


import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicerabbitmq.entity.basic.Article;


public interface IArticleService extends IService<Article> {

    Article getArticleById(Article article);
}
