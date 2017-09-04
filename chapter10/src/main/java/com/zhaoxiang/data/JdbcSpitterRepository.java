package com.zhaoxiang.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Author: Rivers
 * Date: 2017/9/4 21:34
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int count() {

        List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from admin_user");
        return userList.size();
    }
}
