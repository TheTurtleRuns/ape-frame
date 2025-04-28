package com.psj.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;
/**
 * @author pengshj
 * @version 1.0
 * @date 2025/2/19-17:58
 * @description TODO
 */
@RestController
@RequestMapping("/test")
public class TestDemoController {
    @GetMapping("/testmq")
    public  String  testMq(){
  /*      Properties properties = new Properties();

        properties.put(PropertyKeyConst.GROUP_ID,"");
        properties.put(PropertyKeyConst.AccessKey,"");
        properties.put(PropertyKeyConst.SecretKey,"");
        properties.put(PropertyKeyConst.NAMESRV_ADDR,"");
        properties.put(PropertyKeyConst.MessageModel,PropertyValueConst.CLUSTERING);
       final Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("mq_jmzk_yjjg_ds_qb", "zlfx", new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext consumeContext) {
                JSONObject body = JSONObject.parseObject(new String(message.getBody()));
                System.out.println("活动区划"+body.get("hdqh")+",姓名"+body.get("zdryxm")+",证件号码"+body.get("zdryzjhm"));
                return Action.CommitMessage;

            }
        });
*/

        return  "12313";

    }

}
