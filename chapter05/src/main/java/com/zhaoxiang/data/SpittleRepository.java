package com.zhaoxiang.data;

import com.zhaoxiang.entity.Spittle;

import java.util.List;

/**
 * Author: Rivers
 * Date: 2017/9/1 06:41
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
