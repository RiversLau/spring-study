package com.zhaoxiang;

import com.zhaoxiang.data.HibernateSpitterRepository;
import com.zhaoxiang.data.JdbcSpitterRepository;
import com.zhaoxiang.data.SpitterRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

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
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(new String[]{"com.zhaoxiang.domain"});
        Properties props = new Properties();
        props.setProperty("dialect", "org.hibernate.dialect.MySQL55Dialect");
        sessionFactoryBean.setHibernateProperties(props);

        return sessionFactoryBean;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpitterRepository(jdbcTemplate);
    }

    @Bean
    public SpitterRepository spitterRepository(SessionFactory sessionFactory) {

        return new HibernateSpitterRepository(sessionFactory);
    }
}
