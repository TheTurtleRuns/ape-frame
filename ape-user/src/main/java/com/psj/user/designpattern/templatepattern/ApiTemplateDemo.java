package com.psj.user.designpattern.templatepattern;

import com.psj.web.result.Resp;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/1/4-10:21
 * @description TODO
 */
public class ApiTemplateDemo {
    public static void main(String[] args) {
        ApiTemplate apiTemplate = new ApiTemplate();
        Resp result = Resp.succcess();
        apiTemplate.execute(result, new Action() {
            @Override
            public void validate() {
                System.out.println("开始校验");
            }

            @Override
            public void execute() {
                System.out.println("执行");
            }

            @Override
            public void after() {
                System.out.println("后续执行");
            }
        });
        System.out.println(result);
    }
}
