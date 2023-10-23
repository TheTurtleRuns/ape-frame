package com.psj.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.psj.common.mybatisplus.entity.PageResult;
import com.psj.user.convert.UserConverter;
import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.mapper.UserMapper;
import com.psj.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:46
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addUser(@RequestBody UserDto userDto) {
        UserPo userPo = UserConverter.INSTANCE.converDtoToUserPo(userDto);
        int count = userMapper.insert(userPo);
        return count;
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public PageResult<UserPo> getUserPage(UserDto userDto) {
        IPage<UserPo> userPoIPage = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
        IPage<UserPo> userPage = userMapper.getUserPage(userPoIPage);
        PageResult<UserPo> pageresult = new PageResult<>();
        pageresult.loadData(userPage);
        return pageresult;
    }

}
