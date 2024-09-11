package com.psj.user.test;

import com.psj.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/9/11-15:13
 * @description TODO
 */
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class ExecutorConfigTest {
    @Resource(name = "mailThreadPool")
    private ThreadPoolExecutor mailThreadPool;
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            mailThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                     log.info("当前时间"+System.currentTimeMillis());
                }
            });

        }
    }
}
