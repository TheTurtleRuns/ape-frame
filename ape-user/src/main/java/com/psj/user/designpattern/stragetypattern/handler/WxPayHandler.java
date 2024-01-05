package com.psj.user.designpattern.stragetypattern.handler;


import com.psj.user.designpattern.stragetypattern.PayChannelEnum;
import com.psj.user.designpattern.stragetypattern.PayHandler;
import org.springframework.stereotype.Component;

@Component
public class WxPayHandler implements PayHandler {

    @Override
    public PayChannelEnum getChannel() {
        return PayChannelEnum.WX_PAY;
    }

    @Override
    public void dealPay() {
        System.out.println("微信支付");
    }
}
