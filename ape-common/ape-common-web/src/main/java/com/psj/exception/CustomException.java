package com.psj.exception;

/**
 * @ClassName CustomException
 * @Author Pengshj
 * @Description
 * @Date 2023/8/16 16:23
 **/
public class CustomException extends RuntimeException {
    private static final long serialVesrionUID = 1L;
    private Integer code;

    private String message;

    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    public CustomException(AppExceptionCodeMsg appExceptionCodeMsg) {
        this.code = appExceptionCodeMsg.getCode();
        this.message = appExceptionCodeMsg.getMsg();
    }

    public CustomException(Integer code) {
        this.code = code;
    }

    public CustomException(String message) {
        this.message = message;
    }


    public static long getSerialVesrionUID() {
        return serialVesrionUID;
    }

    @Override
    public String getMessage() {
        return message;
    }


    public Integer getCode() {
        return code;
    }
}
