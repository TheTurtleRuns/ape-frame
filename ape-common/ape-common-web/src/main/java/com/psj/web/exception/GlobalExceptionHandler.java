package com.psj.web.exception;

import com.psj.web.result.Resp;
import com.psj.web.result.ResultCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName GlobalExceptionHandler
 * @Author Pengshj
 * @Description
 * @Date 2023/8/16 16:24
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);


    /**
     * 基础异常
     *
     * @return com.psj.result.Resp
     * @Author Pengshj
     * @Description
     * @Date 2023/10/9 9:52
     * @Param [e]
     **/
    @ExceptionHandler(BaseException.class)
    public Resp baseException(BaseException e) {
        return Resp.error(e.getMessage());
    }

    /**
     * 业务异常
     *
     * @return com.psj.result.Resp
     * @Author Pengshj
     * @Description
     * @Date 2023/10/9 9:52
     * @Param [e]
     **/
    @ExceptionHandler(CustomException.class)
    public Resp businessException(CustomException e) {
        if (e.getCode() == null) {
            return Resp.error(e.getMessage());
        }
        return Resp.other(e.getCode(), e.getMessage());

    }

    /**
     * 自定义验证异常
     *
     * @return com.psj.result.Resp
     * @Author Pengshj
     * @Description
     * @Date 2023/10/9 9:53
     * @Param [e]
     **/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Resp methodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuffer sb = null;
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            if (Objects.isNull(sb)) {
                sb = new StringBuffer(error.getDefaultMessage());
            } else {
                sb.append(", ").append(error.getDefaultMessage());
            }
        }
        return Resp.other(ResultCode.PARAMETERVERIFICATION, sb.toString());


    }

    /**
     * 自定义验证异常
     *
     * @return com.psj.result.Resp
     * @Author Pengshj
     * @Description
     * @Date 2023/10/10 14:50
     * @Param [e]
     **/

    @ExceptionHandler(BindException.class)
    public Resp bindException(BindException e) {
        StringBuffer sb = null;
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            if (Objects.isNull(sb)) {
                sb = new StringBuffer(error.getDefaultMessage());
            } else {
                sb.append(", ").append(error.getDefaultMessage());
            }
        }
        return Resp.other(ResultCode.PARAMETERVERIFICATION, sb.toString());


    }


}
