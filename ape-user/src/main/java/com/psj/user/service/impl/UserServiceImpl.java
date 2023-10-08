package com.psj.user.service.impl;

import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.mapper.UserMapper;
import com.psj.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:46
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int addUser(@RequestBody UserDto userDto) {
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userDto, userPo);
        int count = userMapper.insert(userPo);
        return count;
    }
}
