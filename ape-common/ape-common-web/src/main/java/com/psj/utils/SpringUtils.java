package com.psj.utils;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;


/**
 * @ClassName SpringUtils
 * @Author Pengshj
 * @Description
 * @Date 2023/8/16 16:20
 **/
@Component
public class SpringUtils implements BeanFactoryPostProcessor {
    /**
     * Spring应用上下文环境
     */
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }


    /**
     * 获取对象
     *
     * @return T
     * @Author Pengshj
     * @Description Object 一个以所给名字注册的bean的实例
     * @Date 2023/8/16 16:20
     * @Param [name]
     **/
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

    /**
     * @return T
     * @Author Pengshj
     * @Description 获取类型为requiredType的对象
     * @Date 2023/8/16 16:21
     * @Param [clz]
     **/
    public static <T> T getBean(Class<T> clz) throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

    /**
     * @return boolean
     * @Author Pengshj
     * @Description 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     * @Date 2023/8/16 16:21
     * @Param [name]
     **/
    public static boolean containsBean(String name) {
        return beanFactory.containsBean(name);
    }

    /**
     * @return boolean
     * @Author Pengshj
     * @Description 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     * @Date 2023/8/16 16:21
     * @Param [name]
     **/
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.isSingleton(name);
    }

    /**
     * @return java.lang.Class<?> 注册对象的类型
     * @Author Pengshj
     * @Description
     * @Date 2023/8/16 16:22
     * @Param [name]
     **/
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getType(name);
    }

    /**
     * @return java.lang.String[]
     * @Author Pengshj
     * @Description 如果给定的bean名字在bean定义中有别名，则返回这些别名
     * @Date 2023/8/16 16:22
     * @Param [name]
     **/
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return beanFactory.getAliases(name);
    }

    /**
     * @return T
     * @Author Pengshj
     * @Description 获取aop代理对象
     * @Date 2023/8/16 16:23
     * @Param [invoker]
     **/
    @SuppressWarnings("unchecked")
    public static <T> T getAopProxy(T invoker) {
        return (T) AopContext.currentProxy();
    }


}
