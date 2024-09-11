package com.psj.tool;

import org.slf4j.Logger;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/9/11-16:10
 * @description TODO
 */
public class CompletableFutureUtils {
    public static <T> T getResult(Future<T> future, long timeOut, TimeUnit timeUnit,
                                  T defaultValue, Logger logger) {
        try {
            return future.get(timeOut, timeUnit);
        } catch (Exception e) {
            logger.error("CompletableFutureUtils.getResult.error{},", e.getMessage(), e);
            return defaultValue;
        }
    }
}
