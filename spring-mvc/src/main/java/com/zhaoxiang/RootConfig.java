package com.zhaoxiang;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Author: Rivers
 * Date: 2017/8/31 06:57
 */
@Configuration
@ComponentScan(basePackages = {"com.zhaoxiang"},
        excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
