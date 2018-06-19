package com.hexun.pointQuartz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 从配置文件中读取参数
 * Created by zhoudong on 2017/12/21.
 */
@Component
@ConfigurationProperties(prefix="")
@PropertySource("classpath:config-${spring.profiles.active}.properties")
public class Config {
    private String nowProfile;

    public String getNowProfile() {
        return nowProfile;
    }

    public void setNowProfile(String nowProfile) {
        this.nowProfile = nowProfile;
    }
}
