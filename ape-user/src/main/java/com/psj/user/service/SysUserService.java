package com.psj.user.service;

import com.psj.user.entity.po.SysUser;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-15:58
 * @description TODO
 */
public interface SysUserService {


    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

}

