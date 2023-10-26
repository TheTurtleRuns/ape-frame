package com.psj.redis.exception;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/26-14:51
 * @description TODO
 */
public class ShareLockException extends   RuntimeException{
    public ShareLockException(String message){
        super(message);
    }

}
