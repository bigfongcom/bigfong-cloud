package com.bigfong.cloud.servicerabbitmq.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicerabbitmq.entity.basic.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends BaseMapper<Article> {

    public Article getArticleById(@Param("_article") Article article);

}
