package com.psj.user.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-17:12
 * @description TODO
 */
@ApiModel("用户新增")
@Data
public class UserAddReq {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
}
