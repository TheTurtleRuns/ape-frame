package com.psj.user.convert;

import com.psj.user.entity.dto.UserDto;
import com.psj.user.entity.po.UserPo;
import com.psj.user.entity.req.UserAddReq;
import com.psj.user.entity.req.UserReq;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-09T06:48:27+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_431 (Oracle Corporation)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDto converReqToUserDto(UserReq userReq) {
        if ( userReq == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( userReq.getName() );
        userDto.setAge( userReq.getAge() );
        userDto.setPageSize( userReq.getPageSize() );
        userDto.setPageIndex( userReq.getPageIndex() );

        return userDto;
    }

    @Override
    public UserPo converDtoToUserPo(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserPo userPo = new UserPo();

        userPo.setName( userDto.getName() );
        userPo.setAge( userDto.getAge() );

        return userPo;
    }

    @Override
    public UserDto converAddReqToUserDto(UserAddReq userAddReq) {
        if ( userAddReq == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( userAddReq.getName() );
        userDto.setAge( userAddReq.getAge() );

        return userDto;
    }
}
