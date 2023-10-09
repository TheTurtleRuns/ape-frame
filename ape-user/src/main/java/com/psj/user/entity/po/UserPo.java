package com.psj.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.psj.common.mybatisplus.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-10:41
 * @description TODO
 */
@TableName(value = "user")
@Data
public class UserPo  extends BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;

}
