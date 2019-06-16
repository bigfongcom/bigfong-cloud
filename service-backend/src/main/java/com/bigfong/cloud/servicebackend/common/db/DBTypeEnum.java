package com.bigfong.cloud.servicebackend.common.db;

/**
 * <p>
 *  数据源枚举类型
 * </p>
 */
public enum DBTypeEnum {
    basic("basic"), product("product"), manage("manage");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
