package com.psj.common.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-15:04
 * @description TODO
 */
@Data
public class BaseEntity implements Serializable {
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableField(fill = FieldFill.INSERT)
    private Integer deleteFlag;
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
