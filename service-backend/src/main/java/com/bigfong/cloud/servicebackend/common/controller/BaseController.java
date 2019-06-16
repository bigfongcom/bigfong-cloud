package com.bigfong.cloud.servicebackend.common.controller;

import com.alibaba.fastjson.JSON;
import com.bigfong.cloud.servicebackend.common.dto.QueryPage;
import com.bigfong.cloud.servicebackend.system.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class BaseController {

    protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    protected User getCurrentUser() {
        Object obj = getSubject().getPrincipal();
        User user = new User();
        if(obj instanceof User){
            user =  (User) obj;
        }else{
            user = JSON.parseObject(JSON.toJSON(obj).toString(), User.class);
        }
        return user;
    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }

    private Map<String, Object> getData(PageInfo<?> pageInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("rows", pageInfo.getList());
        data.put("total", pageInfo.getTotal());
        return data;
    }

    /**
     * Supplier是JDK8新特性
     * 特点：只有返回值，没有输入参数
     * 如：Supplier<User> user = User::new;
     * 此时并没有构造User对象，当调用`user.get()`方法才获取一个新的User构造对象
     *
     * QueryPage 是封装分页条件的entity，如果没有指定默认查询所有
     */
    public Map<String, Object> selectByPageNumSize(QueryPage page, Supplier<?> s) {
        PageHelper.startPage(page.getPageCode(), page.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getData(pageInfo);
    }

    public Map<String, Object> getToken() {
        Map<String, Object> map = new HashMap<>();
        map.put("token", getSession().getId());
        return map;
    }

}
