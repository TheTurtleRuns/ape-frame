package com.psj.user.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.psj.common.mybatisplus.entity.PageResult;
import com.psj.user.websocket.DemoSocket;
import com.psj.web.result.Resp;
import com.psj.user.convert.UserConverter;
import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.entity.req.UserAddReq;
import com.psj.user.entity.req.UserReq;
import com.psj.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


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
    @Autowired
    private DemoSocket demoSocket;


   /**
    * 新增用户
    * @Author Pengshj
    * @Description
    * @Date 2023/10/17 10:42
    * @Param [userAddReq]
    * @return com.psj.web.result.Resp
    **/
    @PostMapping("addUser")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public Resp addUser(@RequestBody UserAddReq userAddReq) {
        UserDto userDto = UserConverter.INSTANCE.converAddReqToUserDto(userAddReq);
        int i = userService.addUser(userDto);
        demoSocket.sendMessage("新增成功,新增条数:" + 1);
        return Resp.succcess("新增成功,新增条数:" + 1);

    }

    /**
     *
     * 通过id查询用户信息
     * @Author Pengshj
     * @Description
     * @Date 2023/10/17 10:42
     * @Param [id]
     * @return com.psj.web.result.Resp
     **/
    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户信息", notes = "根据id删除用户信息")
    public Resp deleteUser(@PathVariable Integer id) {
        int i = userService.deleteUser(id);
        return Resp.succcess("删除成功,删除条数:" + 1);
    }

    /**
     * 根据查询条件获取用户列表
     * @Author Pengshj
     * @Description
     * @Date 2023/10/17 10:44
     * @Param [userReq]
     * @return com.psj.web.result.Resp
     **/
    @GetMapping("/getUserPage")
    @ApiOperation(value = "获取用户表列表", notes = "分页获取用户表列表")
    public Resp getUserPage( @Valid UserReq userReq) {
        UserDto userDto = UserConverter.INSTANCE.converReqToUserDto(userReq);
        PageResult<UserPo> userPage = userService.getUserPage(userDto);
        return Resp.succcess(userPage);
    }
    public static String formatDate(Date date, Object... pattern) {
        if(date == null){return null;} //处理异常
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    
    public static void main(String[] args) {
       String  va="";

        System.out.println( String.valueOf(va));
    }
}
