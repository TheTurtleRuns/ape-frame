package com.psj.user.designpattern.mydisign.handler;

import com.psj.user.designpattern.mydisign.MyPayHandler;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:26
 * @description TODO
 */
public abstract  class AbstractPayHandler implements MyPayHandler {
    @Override
    public void pay(int code) {
        validateRequest(code);
        dopay(code);
        postPay(code);
    }

    public  abstract  void dopay(int code);

    public  void postPay(int code){
        System.out.println("支付成功后的处理");
    }

    public  void validateRequest(int code){
        System.out.println("参数校验处理");
    }
}
