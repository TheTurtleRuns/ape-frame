package com.psj.user.designpattern.mydisign;

import com.psj.user.designpattern.stragetypattern.PayChannelEnum;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:18
 * @description TODO
 */
public interface MyPayHandler {
    MyPayChannelEnum getChannel();
     void  pay(int code);
}
