package com.psj.common.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:27
 * @description TODO
 */
@Configuration
@MapperScan({ "com.psj.**.mapper" })
public class MybatisConfig {

}
