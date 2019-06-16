package com.bigfong.cloud.servicebackend.common.utils;

import com.alibaba.fastjson.JSON;
import com.bigfong.cloud.servicebackend.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static User getCurrentUser() {
        Object obj = getSubject().getPrincipal();
        User user = new User();
        if(obj instanceof User){
            user =  (User) obj;
        }else{
            user = JSON.parseObject(JSON.toJSON(obj).toString(), User.class);
        }
        return user;
    }
}
