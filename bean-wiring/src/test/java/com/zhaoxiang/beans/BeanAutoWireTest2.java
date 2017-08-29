package com.zhaoxiang.beans;

import com.zhaoxiang.config.CDPlayerJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: Rivers
 * Date: 2017/8/28 22:47
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerJavaConfig.class)
@ActiveProfiles("production")
public class BeanAutoWireTest2 {

    @Autowired
    private CompactDisc randomBeatlesCD;

    @Test
    public void testJavaConfig() {

        randomBeatlesCD.play();
    }
}
