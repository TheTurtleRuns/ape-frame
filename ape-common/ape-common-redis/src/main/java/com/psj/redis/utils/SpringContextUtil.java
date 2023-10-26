package com.psj.redis.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-11:01
 * @description TODO
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;

    }

    public static ApplicationContext getApplicationContext() throws BeansException {
        return applicationContext;
    }

    public static Object getBean(Class type) {
        return applicationContext.getBean(type);
    }


    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}

