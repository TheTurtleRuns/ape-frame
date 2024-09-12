package com.psj.redis.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-10:14
 * @description TODO
 */
@Component
public class RedisUtil {
    @Autowired
    private  RedisTemplate redisTemplate;

    private static final String CACHE_KEY_SEPARATOR = ".";
    private DefaultRedisScript<Boolean> casScript;
    @PostConstruct
    public void init() {
        casScript = new DefaultRedisScript<>();
        casScript.setResultType(Boolean.class);
        casScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("compareAndSet.lua")));
        System.out.println(JSON.toJSON(casScript));
    }

    public Boolean compareAndSet(String key, Long oldValue, Long newValue) {
        List<String> keys = new ArrayList();
        keys.add(key);
        return (Boolean) redisTemplate.execute(casScript, keys, oldValue, newValue);
    }
    /**
     * 写入缓存
     *
     * @return boolean
     * @Author Pengshj
     * @Description
     * @Date 2023/10/25 10:17
     * @Param [key, value]
     **/
    public  boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 写入缓存并设置过期时间
     *
     * @return boolean
     * @Author Pengshj
     * @Description
     * @Date 2023/10/25 10:18
     * @Param [key, value, expireTime, timeUnit]
     **/
    public  boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, timeUnit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public  boolean setNx(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public  boolean setNx(String key, Object value, Long expireTime, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, timeUnit);
    }


    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public  void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }


    public  void del(Collection<String> keys) {
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }

    public  void delByPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        del(keys);
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public  void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public  void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public  boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public  Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 哈希 添加
     *
     * @param key
     * @param hashKey
     * @param value
     */


    /**
     * 哈希获取数据
     *
     * @param key
     * @param hashKey
     * @return
     */
    public  Object hmGet(String key, Object hashKey) {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 列表添加
     *
     * @param k
     * @param v
     */
    public  void lPush(String k, Object v) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 列表获取
     *
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public  List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k, l, l1);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public  void add(String key, Object value) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return
     */
    public  Set<Object> setMembers(String key) {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public  void zAdd(String key, Object value, double scoure) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public  Set<Object> rangeByScore(String key, double scoure, double scoure1) {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    public  long increat(String key, long value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 发布消息
     *
     * @param channel
     * @param message
     */
    public  void sendMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }

    /**
     * 返回 key 的剩余的过期时间
     *
     * @param key
     * @param timeUnit
     * @return
     */
    public  Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }


    public  Set<String> getKeys(String keys) {
        return redisTemplate.keys(keys);
    }




}
