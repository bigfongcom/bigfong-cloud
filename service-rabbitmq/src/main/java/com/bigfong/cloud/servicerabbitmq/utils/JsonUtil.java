package com.bigfong.cloud.servicerabbitmq.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    public static boolean isJson(String content) {
        try {
            JSONObject.parseObject(content);
        } catch (JSONException ex) {
            try {
                JSONObject.parseArray(content);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    //json字符串转换为MAP
    public static Map jsonStrToMap(String s) {
        Map map = new HashMap();
        //注意这里JSONObject引入的是net.sf.json
        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(s);
        Iterator keys = json.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String value = json.get(key).toString();
            if (value.startsWith("{") && value.endsWith("}")) {
                map.put(key, jsonStrToMap(value));
            } else {
                map.put(key, value);
            }

        }
        return map;
    }

    // 将jsonArray字符串转换成List集合
    public static List jsonToList(String json, Class beanClass) {
        if (!StringUtils.isBlank(json)) {
            //这里的JSONObject引入的是 com.alibaba.fastjson.JSONObject;
            return JSONObject.parseArray(json, beanClass);
        } else {
            return null;
        }
    }

    //List集合转换为json
    public static JSON listToJson(List list) {
        JSON json = (JSON) JSON.toJSON(list);
        return json;
    }


}