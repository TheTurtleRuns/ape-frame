package com.psj.user.designpattern.mydisign;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/7-9:33
 * @description TODO
 */
@Component
public class MyPayFactory implements InitializingBean {
    @Resource
    private List<MyPayHandler> myPayHandlerList;
    private Map<MyPayChannelEnum, MyPayHandler> handlerMap = new HashMap<>();
    public MyPayHandler getHandlerByCode(int code) {
        MyPayChannelEnum payChannelEnum = MyPayChannelEnum.getByCode(code);
        return handlerMap.get(payChannelEnum);
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        for (MyPayHandler myPayHandler : myPayHandlerList) {
            handlerMap.put(myPayHandler.getChannel(), myPayHandler);
        }
    }
}
