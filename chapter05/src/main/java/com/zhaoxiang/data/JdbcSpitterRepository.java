package com.zhaoxiang.data;

import com.zhaoxiang.entity.Spitter;
import org.springframework.stereotype.Repository;

/**
 * Author: Rivers
 * Date: 2017/9/1 22:43
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    public Spitter save(Spitter spitter) {

        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
