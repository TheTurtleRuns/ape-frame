package com.psj.user.designpattern.stragetypattern.handler;


import com.psj.user.designpattern.stragetypattern.PayChannelEnum;
import com.psj.user.designpattern.stragetypattern.PayHandler;
import org.springframework.stereotype.Component;

@Component
public class ZfbPayHandler implements PayHandler {

    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.ZFB_PAY;
    }

    @Override
    public void dealPay() {
        System.out.println("支付宝支付");
    }
}
