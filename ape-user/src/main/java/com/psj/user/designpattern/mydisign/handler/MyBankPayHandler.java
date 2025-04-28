package com.psj.user.designpattern.mydisign.handler;


import com.psj.user.designpattern.mydisign.MyPayChannelEnum;
import org.springframework.stereotype.Component;

@Component
public class BankPayHandler extends AbstractPayHandler {

    @Override
    public void dopay(int code) {
        System.out.println("银行卡支付");
    }
    @Override
    public MyPayChannelEnum getChannel() {
        return MyPayChannelEnum.BANK_PAY;
    }
}
