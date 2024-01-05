package com.psj.user.controller;

import com.psj.redis.utils.RedisShareLockUtil;
import com.psj.redis.utils.RedisUtil;
import com.psj.user.entity.po.SysUserPo;
import com.psj.user.service.SysUserService;
import com.psj.web.exception.AppExceptionCodeMsg;
import com.psj.web.result.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SysUserController
 * @Author Pengshj
 * @Description
 * @Date 2023/10/9 16:03
 **/
@Slf4j
@RestController
@RequestMapping("/sysuser")
@Api(tags = "系统用户表")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @Resource

    private RedisUtil redisUtil;
    @Resource
    private RedisShareLockUtil redisShareLockUtil;

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
