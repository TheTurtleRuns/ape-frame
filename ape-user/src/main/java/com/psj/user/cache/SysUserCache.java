package com.psj.user.cache;

import com.psj.redis.init.AbstractCache;
import com.psj.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-10:36
 * @description TODO
 */
@Component
public class SysUserCache extends AbstractCache {
    private static final String SYS_USER_CACHE_KEY = "SYS_USER";

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void initCache() {
        redisUtil.set("123", "45600");
    }

    @Override
    public <T> T getCache(String key) {

        if (!redisTemplate.hasKey(key).booleanValue()) {
            reloadCache();
        }
        return (T) redisTemplate.opsForValue().get(key);
    }
    @Override
    public void clearCache() {
        redisTemplate.delete(SYS_USER_CACHE_KEY);
    }
    @Override
    public void reloadCache() {
        clearCache();
        initCache();
    }


}
