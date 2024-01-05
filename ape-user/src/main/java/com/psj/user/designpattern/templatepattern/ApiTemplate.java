package com.psj.user.designpattern.templatepattern;

import com.psj.web.result.Resp;
import com.psj.web.result.ResultCode;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/1/4-10:20
 * @description TODO
 */
public class ApiTemplate {
    public void execute(Resp result, final Action action) {
        try {
            action.validate();
            action.execute();
            action.after();
            result.setSuccess(true);
            result.setCode(1024);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
        }
    }
}
