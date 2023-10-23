package com.psj.user.convert;

import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.entity.req.UserAddReq;
import com.psj.user.entity.req.UserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/10-15:43
 * @description TODO
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    /**
     * 将UserReq装换为 UserDto
     * @Author Pengshj
     * @Description
     * @Date 2023/10/17 10:40
     * @Param [userReq]
     * @return com.psj.user.entity.dto.UserDto
     **/
    UserDto converReqToUserDto(UserReq userReq);
    /**
     * 将 UserDto 装换为 UserPo 
     * @Author Pengshj
     * @Description
     * @Date 2023/10/17 10:40
            * @Param [userDto]
            * @return com.psj.user.entity.po.UserPo
     **/
    UserPo converDtoToUserPo(UserDto userDto);
    /**
     * 将 UserAddReq 装换为 UserDto
     * @Author Pengshj
     * @Description
     * @Date 2023/10/17 10:40
     * @Param [userAddReq]
     * @return com.psj.user.entity.dto.UserDto
     **/
    UserDto converAddReqToUserDto(UserAddReq userAddReq);

}
