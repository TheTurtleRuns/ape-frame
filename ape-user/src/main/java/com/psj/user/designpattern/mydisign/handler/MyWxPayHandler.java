package com.psj.user.designpattern.mydisign.handler;


import com.psj.user.designpattern.mydisign.MyPayChannelEnum;
import org.springframework.stereotype.Component;

@Component
public class MyWxPayHandler extends AbstractPayHandler  {
    @Override
    public void dopay(int code) {
        System.out.println("微信支付");
    }

    @Override
    public MyPayChannelEnum getChannel() {
        return MyPayChannelEnum.WX_PAY;
    }
}
