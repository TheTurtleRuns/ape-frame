package com.psj.common.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/8-11:20
 * @description TODO
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"createBy",String.class,"psj");
        this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
        this.strictInsertFill(metaObject,"deleteFlag",Integer.class,0);
        this.strictInsertFill(metaObject,"version",Integer.class,0);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"updateBy",String.class,"psj");
        this.strictUpdateFill(metaObject,"updateTime", Date.class,new Date());
    }
}
