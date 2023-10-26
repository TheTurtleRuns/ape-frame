package com.psj.user.cache;

import com.psj.redis.init.AbstractCache;
import com.psj.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-10:36
 * @description TODO
 */
@Component
public class SysUserCache extends AbstractCache {

    @Autowired
    private  RedisUtil redisUtil;
    @Override
    public void initCache() {
        redisUtil.set("123","45600");
    }

    @Override
    public <T> T getCache(String key) {
        return super.getCache(key);
    }

    @Override
    public void clearCache() {
        super.clearCache();
    }


    @Override
    public void reloadCache() {
        clearCache();
        initCache();
    }
}
