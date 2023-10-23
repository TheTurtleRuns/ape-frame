package com.psj.web.exception;

import com.psj.web.utils.MessageUtils;
import org.springframework.util.StringUtils;

/**
 * @ClassName BaseException
 * @Author Pengshj
 * @Description
 * @Date 2023/8/16 16:23
 **/
public class BaseException extends RuntimeException {
    private static final long serialVesrionUID = 1L;
    //所属模块
    private String module;
    //错误代码
    private Integer code;
    //错误信息
    private String message;
    //参数
    private Object[] args;

    public BaseException(String module, Integer code, String message, Object[] args) {
        this.module = module;
        this.code = code;
        this.message = message;
        this.args = args;

    }

    public BaseException(String module, Integer code, String message) {
        this(module, code, message, null);
    }

    public BaseException(String module, Integer code, Object[] args) {
        this(module, code, null, args);
    }

    public BaseException(Integer code, String message) {
        this(null, code, message, null);
    }

    public BaseException(String message) {
        this(null, null, message, null);
    }

    @Override
    public String getMessage() {
        String defMessage = null;
        if (StringUtils.isEmpty(code)) {
            MessageUtils.message(String.valueOf(code), args);
        }

        if (defMessage == null) {
            defMessage = message;
        }
        return defMessage;
    }

    public static long getSerialVesrionUID() {
        return serialVesrionUID;
    }

    public String getModule() {
        return module;
    }

    public Integer getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }
}
