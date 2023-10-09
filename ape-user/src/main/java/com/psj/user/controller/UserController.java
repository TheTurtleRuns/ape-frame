package com.psj.user.controller;

import com.psj.common.mybatisplus.entity.PageResult;
import com.psj.result.Resp;
import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.entity.req.UserAddReq;
import com.psj.user.entity.req.UserReq;
import com.psj.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:40
 * @description TODO
 */

@RestController
@RequestMapping("/user")
@Api(tags = "用户表")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("addUser")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public Resp addUser(@RequestBody UserAddReq userAddReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userAddReq, userDto);
        int i = userService.addUser(userDto);
        return Resp.succcess("新增成功,新增条数:" + 1);
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息")
    public Resp deleteUser(@PathVariable Integer id) {

        int i = userService.deleteUser(id);
        return Resp.succcess("删除成功,删除条数:" + 1);
    }


    @GetMapping("/getUserPage")
    @ApiOperation(value = "获取用户表列表", notes = "分页获取用户表列表")
    public Resp getUserPage(@RequestBody UserReq userReq) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userReq, userDto);
        PageResult<UserPo> userPage = userService.getUserPage(userDto);
        return Resp.succcess(userPage);
    }
}
