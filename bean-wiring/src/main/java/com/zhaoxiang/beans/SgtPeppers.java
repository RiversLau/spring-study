package com.zhaoxiang.beans;

import org.springframework.stereotype.Component;

/**
 * Author: Rivers
 * Date: 2017/8/28 21:56
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
