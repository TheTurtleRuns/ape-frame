package com.psj.redis.init;

import com.psj.redis.utils.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author pengshj
 * @version 1.0
 * @date 2023/10/25-10:32
 * @description TODO
 */
@Component
public class InitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beansMap = applicationContext.getBeansOfType(AbstractCache.class);
        if (beansMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, AbstractCache> entrty : beansMap.entrySet()) {
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entrty.getValue().getClass());
            abstractCache.initCache();
        }
    }
}
