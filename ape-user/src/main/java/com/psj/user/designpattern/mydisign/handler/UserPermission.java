package com.psj.user.designpattern.mydisign.handler;

/**
 * @author pengshj
 * @version 1.0
 * @date 2025/3/19-13:59
 * @description TODO
 */
public enum UserPermission {

    /**
     * 基本权限
     */
    BASIC,

    /**
     * 已实名认证权限
     */
    AUTH,

    /**
     * 已冻结权限
     */
    FROZEN,

    /**
     * 无任何权限
     */
    NONE;
}
