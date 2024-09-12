package com.psj.web.config;

import com.psj.web.trace.TraceIdFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/9/12-10:45
 * @description TODO
 */
@Configuration
public class FilterConfig {

    @Resource
    private TraceIdFilter traceIdFilter;

    @Bean
    public FilterRegistrationBean registerTraceFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(traceIdFilter);
        registration.addUrlPatterns("/*");
        registration.setName("traceIdFilter");
        registration.setOrder(1);
        return registration;
    }
}
