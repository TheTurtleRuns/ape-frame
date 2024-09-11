package com.psj.user.config;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/9/11-15:28
 * @description TODO
 */
public class CustomNameThreadFactory implements ThreadFactory {

    private  final AtomicInteger poolNumber=new AtomicInteger(1);
    private  final AtomicInteger threadNumber=new AtomicInteger(1);
    private  final  ThreadGroup  group;
    private  final  String    namePrefix;
    CustomNameThreadFactory(String name){
        SecurityManager s = System.getSecurityManager();
        group=(s!=null)?s.getThreadGroup():Thread.currentThread().getThreadGroup();
        if (StringUtils.isEmpty(name)){
            name="pool";
        }
        namePrefix=name+"-"+poolNumber.getAndIncrement()+"-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
        return thread;
    }
}
