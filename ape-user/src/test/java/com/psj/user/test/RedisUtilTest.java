package com.psj.user.test;

import com.psj.user.UserApplication;
import com.psj.user.designpattern.mydisign.MyPayHandlerDemo;
import com.psj.user.designpattern.stragetypattern.PayHandlerDemo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Redis的lua测试类
 *
 * @author: ChickenWing
 * @date: 2023/1/16
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class RedisUtilTest {
    @Resource
    MyPayHandlerDemo myPayHandlerDemo;

    @Resource
    PayHandlerDemo payHandlerDemo;
    @Test
    public void testCompareAndSet() throws Exception {
        payHandlerDemo.dealPay(0);
        myPayHandlerDemo.dealPay(2);
    }

}
