package com.psj.user.job;

import com.psj.user.service.SysUserService;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author pengshj
 * @version 1.0
 * @date 2024/9/11-15:02
 * @description TODO
 */
@Component
public class SampleXxlJob {
    private static Logger logger = LoggerFactory.getLogger(SampleXxlJob.class);

    @Resource
    private SysUserService sysUserService;
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public void demoJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
          logger.info("人家是第一次哦");
        for (int i = 0; i < 5; i++) {
            XxlJobHelper.log("beat at:" + i);
            logger.info("人家是第"+i+"次哦");
            TimeUnit.SECONDS.sleep(2);
        }
    }

}
