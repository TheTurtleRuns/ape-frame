package com.psj.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/7-14:20
 * @description TODO
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public  String getHelloWord(){
        return  "helloword";
    }
}
