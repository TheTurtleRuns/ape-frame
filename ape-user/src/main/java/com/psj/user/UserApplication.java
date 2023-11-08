package com.psj.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/7-14:18
 * @description TODO
 */
@SpringBootApplication(scanBasePackages = { "com.psj" })
@ComponentScan(basePackages = {"com.psj"})
@EnableCaching
public class UserApplication {

    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector","org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class);
    }
}
