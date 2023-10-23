package com.psj.user.service;

import com.psj.user.entity.po.SysUserPo;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-15:58
 * @description TODO
 */
public interface SysUserService {


    int deleteByPrimaryKey(Long id);

    int insert(SysUserPo record);

    int insertSelective(SysUserPo record);

    SysUserPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserPo record);

    int updateByPrimaryKey(SysUserPo record);

}

