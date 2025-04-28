package com.psj.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import org.apache.ibatis.annotations.Param;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:46
 * @description TODO
 */
public interface UserMapper extends BaseMapper<UserPo> {
    IPage<UserPo>  getUserPage(@Param("userPoIPage") IPage<UserPo> userPoIPage , @Param("userDto") UserDto userDto);
}
