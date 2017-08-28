package com.zhaoxiang.beans;

import com.zhaoxiang.config.CDPlayerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author: Rivers
 * Date: 2017/8/28 22:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class BeanAutoWireTest {

    @Autowired
    private CompactDisc cd;
    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void testComponentScaning() {

        assert cd != null;
        mediaPlayer.play();
    }
}
