package com.psj.user.designpattern.stragetypattern;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class PayHandlerDemo {

    @Resource
    private PayFactory payFactory;

    public void dealPay(int code) {
        PayHandler payHandler = payFactory.getHandlerByCode(code);
        payHandler.dealPay();
    }

}
