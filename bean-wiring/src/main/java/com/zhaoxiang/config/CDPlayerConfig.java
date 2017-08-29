package com.zhaoxiang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

/**
 * Author: Rivers
 * Date: 2017/8/28 22:00
 */
@Configuration
@ComponentScan(basePackages = {"com.zhaoxiang.beans"})
@ActiveProfiles("develop")
public interface CDPlayerConfig {

}
