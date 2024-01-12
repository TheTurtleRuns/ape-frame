package com.psj.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
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
@SpringBootApplication
@ComponentScan(basePackages = {"com.psj"})
@MapperScan(value = "com.psj.*.mapper")

@EnableCaching
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        System.setProperty("Log4jContextSelector","org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(UserApplication.class);
    }
}
