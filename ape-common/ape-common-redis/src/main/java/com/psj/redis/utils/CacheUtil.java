package com.psj.redis.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/1/8-10:10
 * @description TODO
 */
@Component
@Slf4j
public class CacheUtil<K, V> {
    @Value("${guava.cache.switch}")
    private Boolean switchCache;
    //初始化本地缓存
    private Cache<String, String> localCache = CacheBuilder.newBuilder()
            .maximumSize(5000)
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .build();

    public Map<K, V> getResult(List<K> skuIdList, String cacheKeyPrefix, Class<V> clazz,  Function<List<K>, Map<K, V>> function,String cacheSuffix) {
        if (CollectionUtils.isEmpty(skuIdList)) {
            return Collections.EMPTY_MAP;
        }

        Map<K, V> resultMap = new HashMap<>(16);
        if (!switchCache) {
            resultMap = function.apply(skuIdList);
            return resultMap;
        }
        //声明本地缓存没有的集合
        List<K> noCacheIdList = new LinkedList<>();
        for (K id : skuIdList) {
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            String content = localCache.getIfPresent(cacheKey);
            if (StringUtils.isNotBlank(content)) {
                V v = JSON.parseObject(content, clazz);
                resultMap.put(id, v);
            } else {
                noCacheIdList.add(id);
            }
        }
        if (CollectionUtils.isEmpty(noCacheIdList)) {
            return resultMap;
        }
        Map<K, V> noCacheResultMap = function.apply(noCacheIdList);
        if (noCacheResultMap == null || noCacheResultMap.isEmpty()) {
            return resultMap;
        }
        for (Map.Entry<K, V> entry : noCacheResultMap.entrySet()) {
            K id = entry.getKey();
            V result = entry.getValue();
            resultMap.put(id, result);
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            localCache.put(cacheKey, JSON.toJSONString(result));
        }
        return resultMap;
    }
}
