package com.psj.user.designpattern.mydisign.handler;


import com.psj.user.designpattern.mydisign.MyPayChannelEnum;
import com.psj.user.designpattern.stragetypattern.PayChannelEnum;
import com.psj.user.designpattern.stragetypattern.PayHandler;
import org.springframework.stereotype.Component;

@Component
public class ZfbPayHandler extends  AbstractPayHandler{
    @Override
    public void dopay(int code) {
        System.out.println("支付宝支付");
    }

    @Override
    public MyPayChannelEnum getChannel() {
        return MyPayChannelEnum.ZFB_PAY;
    }
}
