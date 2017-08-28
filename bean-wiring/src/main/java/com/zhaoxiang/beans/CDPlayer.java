package com.zhaoxiang.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author: Rivers
 * Date: 2017/8/28 22:23
 */
@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

//    @Autowired
//    public CDPlayer(CompactDisc cd) {
//        this.cd = cd;
//    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {

        cd.play();
    }
}
