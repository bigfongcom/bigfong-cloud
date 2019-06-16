package com.bigfong.cloud.servicebackend.common.exception;

import com.bigfong.cloud.cloudcommon.base.Code;
import lombok.Getter;
import lombok.Setter;

public class GlobalException extends RuntimeException {

    @Getter
    @Setter
    private String msg;

    @Getter
    @Setter
    private Integer code;

    public GlobalException(String message) {
        this.code = Code.SYSTEM_ERROR.getCode();
        this.msg = message;
    }

    public GlobalException(Code enums, String message) {
        this.code = enums.getCode();
        this.msg = message;
    }
}
