package com.psj.user.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:41
 * @description TODO
 */
@Data
@ApiModel("用户查询")
public class UserReq {
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "每页大小", required = true)
    @Max(value = 500, message = "pageSize不能超过500")
    @NotNull(message = "pageSize不能为空")
    private Integer pageSize;
    @ApiModelProperty(value = "当前页", required = true)
    @Min(value = 1, message = "pageIndex不能小于1")
    @NotNull(message = "pageIndex 不能为空")
    private Integer pageIndex;
}
