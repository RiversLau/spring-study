package com.zhaoxiang;

import com.zhaoxiang.data.JdbcSpitterRepository;
import com.zhaoxiang.data.SpitterRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Author: Rivers
 * Date: 2017/9/4 21:18
 */
@Configuration
public class ContextConfig {

    @Bean
    public DataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://rm-wz9l56083z86nztz1o.mysql.rds.aliyuncs.com:3306/rrdkf?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("rrdkf");
        dataSource.setPassword("RRDKF@1qazxsw2");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpitterRepository(jdbcTemplate);
    }
}
