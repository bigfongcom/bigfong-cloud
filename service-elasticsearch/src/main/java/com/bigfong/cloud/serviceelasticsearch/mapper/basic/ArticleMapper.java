package com.bigfong.cloud.serviceelasticsearch.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.serviceelasticsearch.entity.basic.Article;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper extends BaseMapper<Article> {

    public Article getArticleById(@Param("_article") Article article);

}
