package com.psj.web.result;

import com.psj.web.exception.AppExceptionCodeMsg;
import lombok.Data;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-15:20
 * @description TODO
 */
@Data
public class Resp<T> {
    private static final long serialVesrionUID = 1L;
    private Integer code;
    private String msg;
    private Boolean success;
    private T data;

    private Resp(Integer code, String msg, T data, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    private Resp() {
    }

    public static Resp succcess() {
        Resp result = new Resp();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg(ResultMessage.SUCCESS);
        return result;
    }

    public static <T> Resp succcess(T data) {
        Resp result = new Resp();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS);
        result.setMsg(ResultMessage.SUCCESS);
        result.setData(data);
        return result;
    }

    public static Resp error() {
        Resp result = new Resp();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMsg(ResultMessage.ERROR);
        return result;
    }

    public static <T> Resp error(T data) {
        Resp result = new Resp();
        result.setSuccess(true);
        result.setCode(ResultCode.ERROR);
        result.setMsg(ResultMessage.ERROR);
        result.setData(data);
        return result;
    }

    public static Resp other(Integer resultCode, String resultMessage) {
        return other(resultCode, resultMessage, null);
    }

    public static Resp other(AppExceptionCodeMsg appExceptionCodeMsg) {
        return other(appExceptionCodeMsg.getCode(), appExceptionCodeMsg.getMsg(), null);
    }

    public static Resp other(String resultMessage) {
        return other(null, resultMessage, null);
    }

    public static <T> Resp other(Integer resultCode, String resultMessage, T data) {
        Resp result = new Resp();
        result.setSuccess(true);
        result.setCode(resultCode);
        result.setMsg(resultMessage);
        result.setData(data);
        return result;
    }

}
