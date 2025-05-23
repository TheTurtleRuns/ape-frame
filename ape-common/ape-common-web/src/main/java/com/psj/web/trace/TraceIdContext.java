package com.psj.web.trace;

import com.psj.tool.IdWorkerUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * TraceId上下文
 *
 * @author: ChickenWing
 * @date: 2023/1/26
 */
public class TraceIdContext {

    public static final ThreadLocal<String> CURRENT_TRACE_ID = new InheritableThreadLocal<>();

    public static String generateTraceId() {
        IdWorkerUtils idWorkerUtils = new IdWorkerUtils(1, 1, 0);
        return String.valueOf(idWorkerUtils.nextId())  ;
    }

    public static String getTraceId() {
        return MDC.get(TraceIdConstant.TRACE_ID);
    }

    public static void setTraceId(String traceId) {
        MDC.put(TraceIdConstant.TRACE_ID, traceId);
    }

    public static void clearTraceId() {
        CURRENT_TRACE_ID.set(null);
        CURRENT_TRACE_ID.remove();
    }

}