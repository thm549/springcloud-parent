package com.thm.springcloud.base;

import cn.hutool.http.HttpStatus;
import lombok.Data;

@Data
public class CommonResult {

    private Integer code;

    private String msg;

    private Object data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static CommonResult success(Object data) {
        return new CommonResult(HttpStatus.HTTP_OK, "OK", data);
    }

    public static CommonResult success(String msg,Object data) {
        return new CommonResult(HttpStatus.HTTP_OK, msg, data);
    }

    public static CommonResult error(String msg) {
        return new CommonResult(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }

}
