package com.psj.user.designpattern.mydisign.handler;


import com.psj.user.designpattern.mydisign.MyPayChannelEnum;
import org.springframework.stereotype.Component;

@Component
public class MyZfbPayHandler extends  AbstractPayHandler{
    @Override
    public void dopay(int code) {
        System.out.println("支付宝支付");
    }

    @Override
    public MyPayChannelEnum getChannel() {
        return MyPayChannelEnum.ZFB_PAY;
    }
}
