package com.hexun.pointQuartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * 定时任务演示类
 * @author zhoudong
 *
 */
@Component
//@EnableScheduling
public class ExampleTimer {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 每10秒执行一次
    @Scheduled(fixedRate = 10000)
    public void timerRate() {
        log.info(" ** fixedRate 运行..");
    }

    //第一次延迟1秒执行，当执行完后2秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void timerInit() {
        log.info(" ** delay : {}", new Date());
    }

    //每天10点54分00秒时执行
    @Scheduled(cron = "00 10 16 * * ?")
    public void timerCron() {
        log.info(" ** crontab 运行 : {}", new Date());
    }
}
