package com.psj.user.service.impl;

import com.psj.user.entity.po.SysUserPo;
import com.psj.user.mapper.SysUserMapper;
import com.psj.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-15:57
 * @description TODO
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUserPo record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUserPo record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUserPo selectByPrimaryKey(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUserPo record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUserPo record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

}


