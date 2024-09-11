package com.psj.user.cache;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.psj.redis.init.AbstractCache;
import com.psj.redis.utils.RedisUtil;
import com.psj.user.entity.dto.UserDto;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
