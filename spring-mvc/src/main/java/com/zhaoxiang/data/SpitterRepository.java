package com.zhaoxiang.data;

import com.zhaoxiang.entity.Spitter;

/**
 * Author: Rivers
 * Date: 2017/9/1 22:01
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
