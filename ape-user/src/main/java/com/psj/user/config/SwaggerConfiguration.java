package com.psj.user.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-16:51
 * @description TODO
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfiguration {

    @Bean
    public Docket baseRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.psj.user.controller")).paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("学习接口文档").description("学习接口文档Swagger版").termsOfServiceUrl("")
                .contact(new Contact("pengshj", "", "")).version("1.0").build();
    }

}
