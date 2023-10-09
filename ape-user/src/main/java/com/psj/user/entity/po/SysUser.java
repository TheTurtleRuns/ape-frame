package com.psj.user.entity.po;

import java.util.Date;
import lombok.Data;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/9-16:02
 * @description TODO
 */
@Data
public class SysUser {
    private Long id;

    private String userName;

    private Integer age;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private Byte deleteFlag;

    private Integer version;
}