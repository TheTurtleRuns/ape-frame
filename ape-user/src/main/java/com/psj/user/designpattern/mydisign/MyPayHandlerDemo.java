package com.psj.user.designpattern.mydisign;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:39
 * @description TODO
 */
@Component
public class MyPayHandlerDemo {
    @Resource
    private MyPayFactory myPayFactory;
    public void dealPay(int code) {
        MyPayHandler myPayHandler = myPayFactory.getHandlerByCode(code);
        myPayHandler.pay(code);
    }
}
