package com.psj.redis.utils;

import com.psj.redis.exception.ShareLockException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/26-14:44
 * @description TODO
 */
@Component
public class RedisShareLockUtil {
    @Resource
    private RedisUtil redisUtil;
    private Long TIME_OUT = 1000L;

    /**
     * 枷锁
     *
     * @return boolean
     * @Author Pengshj
     * @Description
     * @Date 2023/10/26 14:45
     * @Param []
     **/
    public boolean lock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁参数异常");
        }
        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        Boolean result = false;
        while (currentTime < outTime) {
            result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            if (result) {
                return result;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentTime = System.currentTimeMillis();
        }


        return result;
    }

    /**
     * 解锁
     *
     * @return boolean
     * @Author Pengshj
     * @Description
     * @Date 2023/10/26 14:45
     * @Param []
     **/
    public boolean unLock(String lockKey, String requestId) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId)) {
            throw new ShareLockException("分布式锁-解锁参数异常");
        }
        try {
            Object value = redisUtil.get(lockKey);
            if (value.equals(requestId)) {
                redisUtil.remove(lockKey);
                return true;
            }
        } catch (Exception e) {
        }
        return false;

    }

    /**
     * 尝试加锁
     *
     * @return boolean
     * @Author Pengshj
     * @Description
     * @Date 2023/10/26 14:45
     * @Param []
     **/
    public boolean tryLock(String lockKey, String requestId, Long time) {
        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new ShareLockException("分布式锁-加锁参数异常");
        }
        Boolean result = false;
        return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);

    }
}
