package com.psj.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author  pengshj
 * @date    2024/9/11-15:16
 * @version 1.0
 * @description  TODO
 *
 */

@Configuration
public class ExecutorConfig {
    @Bean(name = "mailThreadPool")
    public ThreadPoolExecutor getMailThreadPool(){
        CustomNameThreadFactory mail = new CustomNameThreadFactory("mail");
        return  new ThreadPoolExecutor(20,50,5,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50),mail,
                new ThreadPoolExecutor.DiscardPolicy()) ;
    }
}
