package com.psj.user.designpattern.stragetypattern;

public interface PayHandler {

    PayChannelEnum getChannel();

    void dealPay();

}
