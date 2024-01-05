package com.psj.user.designpattern.templatepattern;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/1/4-10:20
 * @description TODO
 */
public interface Action {
    /**
     * 参数校验，可以自定义异常抛出
     */
    void validate();

    /**
     * 执行
     */
    void execute();

    /**
     * 后续
     */
    void after();
}
