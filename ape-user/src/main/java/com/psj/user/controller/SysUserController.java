package com.psj.user.controller;

import com.psj.web.exception.AppExceptionCodeMsg;
import com.psj.web.result.Resp;
import com.psj.user.entity.po.SysUserPo;
import com.psj.user.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName SysUserController
 * @Author Pengshj
 * @Description
 * @Date 2023/10/9 16:03
 **/
@RestController
@RequestMapping("/sysuser")
@Api(tags = "系统用户表")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectById/{id}")
    @ApiOperation(value = "根据用户id查询用户", notes = "根据用户id查询用户信息")
    public Resp selectOne(@PathVariable Long id) {
        SysUserPo sysUser = sysUserService.selectByPrimaryKey(id);
        if (sysUser == null) {
            return Resp.other(AppExceptionCodeMsg.USERNAME_NOT_EXISTS);
        }
        return Resp.succcess(sysUser);
    }

}
