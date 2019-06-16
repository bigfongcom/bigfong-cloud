package com.bigfong.cloud.servicedemo.entity.basic;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.sql.Timestamp;

public class Article  extends Model<Article> {

    /**
     * 主键自增编号
     */
    private Integer article_id;
    /**
     * 作者id
     */
    private Integer article_user_id;
    /**
     * 标题
     */
    private String article_title;
    private String article_content;
    private Integer article_view_count;
    private Integer article_comment_count;
    private Integer article_like_count;
    private Short article_is_comment;
    private Short article_status;
    private Integer article_order;
    private Timestamp article_update_time;
    private Timestamp article_create_time;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getArticle_user_id() {
        return article_user_id;
    }

    public void setArticle_user_id(Integer article_user_id) {
        this.article_user_id = article_user_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content() {
        return article_content;
    }

    public void setArticle_content(String article_content) {
        this.article_content = article_content;
    }

    public Integer getArticle_view_count() {
        return article_view_count;
    }

    public void setArticle_view_count(Integer article_view_count) {
        this.article_view_count = article_view_count;
    }

    public Integer getArticle_comment_count() {
        return article_comment_count;
    }

    public void setArticle_comment_count(Integer article_comment_count) {
        this.article_comment_count = article_comment_count;
    }

    public Integer getArticle_like_count() {
        return article_like_count;
    }

    public void setArticle_like_count(Integer article_like_count) {
        this.article_like_count = article_like_count;
    }

    public Short getArticle_is_comment() {
        return article_is_comment;
    }

    public void setArticle_is_comment(Short article_is_comment) {
        this.article_is_comment = article_is_comment;
    }

    public Short getArticle_status() {
        return article_status;
    }

    public void setArticle_status(Short article_status) {
        this.article_status = article_status;
    }

    public Integer getArticle_order() {
        return article_order;
    }

    public void setArticle_order(Integer article_order) {
        this.article_order = article_order;
    }

    public Timestamp getArticle_update_time() {
        return article_update_time;
    }

    public void setArticle_update_time(Timestamp article_update_time) {
        this.article_update_time = article_update_time;
    }

    public Timestamp getArticle_create_time() {
        return article_create_time;
    }

    public void setArticle_create_time(Timestamp article_create_time) {
        this.article_create_time = article_create_time;
    }
}
