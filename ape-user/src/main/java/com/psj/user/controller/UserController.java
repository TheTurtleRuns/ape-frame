package com.psj.user.controller;

import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.req.UserReq;
import com.psj.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:40
 * @description TODO
 */

@RestController
public class UserController {
@Autowired
private UserService userService;
@PostMapping("addUser")
    public int  addUser(UserReq req){
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(req,userDto);
    return userService.addUser(userDto);

    }
}