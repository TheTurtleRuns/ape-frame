package com.psj.exception;

/**
 * @ClassName AppExceptionCodeMsg
 * @Author Pengshj
 * @Description 业务异常代码
 * @Date 2023/8/16 16:23
 **/
public enum AppExceptionCodeMsg {
    //用户相关业务异常
    USERNAME_NOT_EXISTS(10001, "用户名不存在"),
    INVALID_CODE(10000, "验证码无效"),
    USER_CREDIT_NOT_ENOUTH(10002, "用户积分不足");
    //代码
    private Integer code;
    //描述
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    AppExceptionCodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
