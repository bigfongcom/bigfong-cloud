package com.bigfong.cloud.cloudcommon.base;

import lombok.Getter;
import lombok.Setter;

public enum Code {

    SUCCESS(200, "操作成功"),
    SYSTEM_ERROR(1000, "系统错误"),
    PARAM_ERROR(1001, "参数错误"),
    PARAM_REPEAT(1002, "参数已存在"),
    CODE_ERROR(1003,"验证码错误"),
    SERVICE_HAS_FAIL(1004,"远程服务请求失败"),
    //后台模块
    PERMISSION_ERROR(2001, "没有操作权限"),
    ACCOUNT_UNKNOWN(2002, "账户不存在"),
    ACCOUNT_ERROR(2003,"用户名或密码错误"),
    //产品模块

    OTHER(-100, "其他错误");

    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String info;

    Code(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
