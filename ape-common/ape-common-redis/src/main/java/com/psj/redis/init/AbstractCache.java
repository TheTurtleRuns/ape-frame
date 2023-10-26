package com.psj.redis.init;

import org.springframework.stereotype.Component;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-10:28
 * @description TODO
 */
@Component
public abstract class AbstractCache {

    public void initCache() {
    }

    public <T> T getCache(String key) {
        return null;
    }

    public void clearCache() {
    }

    public void reloadCache() {
        clearCache();
        initCache();
    }
}
