package com.psj.user.service;

import com.psj.common.mybatisplus.entity.PageResult;
import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:45
 * @description TODO
 */
public interface UserService  {

    int addUser(UserDto userDto);

    int deleteUser(Integer id);

    PageResult<UserPo> getUserPage(UserDto userDto);
}
