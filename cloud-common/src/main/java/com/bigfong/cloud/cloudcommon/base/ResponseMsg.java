package com.bigfong.cloud.cloudcommon.base;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMsg {

    private Integer code;
    private String msg;
    private Object data;

    public ResponseMsg() {
        this.code = Code.SUCCESS.getCode();
        this.msg = Code.SUCCESS.getInfo();
    }

    public ResponseMsg(Code enums) {
        this.code = enums.getCode();
        this.msg = enums.getInfo();
    }

    public ResponseMsg(Code enums, Object data) {
        this.code = enums.getCode();
        this.msg = enums.getInfo();
        this.data = data;
    }

    public ResponseMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMsg(Code enums, Object data, String msg) {
        this.code = enums.getCode();
        this.msg = msg;
        this.data = data;
    }



    public static ResponseMsg success() {
        return new ResponseMsg(Code.SUCCESS);
    }

    public static ResponseMsg success(Object data) {
        return new ResponseMsg(Code.SUCCESS, data);
    }

    public static ResponseMsg error() {
        return new ResponseMsg(Code.SYSTEM_ERROR);
    }
}
