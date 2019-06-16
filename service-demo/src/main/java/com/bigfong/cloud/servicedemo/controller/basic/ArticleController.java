package com.bigfong.cloud.servicedemo.controller.basic;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.servicedemo.entity.basic.Article;
import com.bigfong.cloud.servicedemo.service.basic.IArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping("/articlebasic")
public class ArticleController {
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private IArticleService articleService;

    @PostMapping("/getArticleById")
    @ResponseBody
    public ResponseMsg getArticleById(@RequestBody Article article) {
        logger.info("==============getArticleById==============");
        return new ResponseMsg(Code.SUCCESS,articleService.getArticleById(article),"根据id获取信息成功！");
    }
}
