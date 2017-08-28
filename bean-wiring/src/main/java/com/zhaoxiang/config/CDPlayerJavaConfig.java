package com.zhaoxiang.config;

import com.zhaoxiang.beans.CompactDisc;
import com.zhaoxiang.beans.SgtPeppers;
import com.zhaoxiang.beans.WhiteAlbum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Rivers
 * Date: 2017/8/28 22:37
 */
@Configuration
public class CDPlayerJavaConfig {

    @Bean
    public CompactDisc sgtPeppers() {

        return new SgtPeppers();
    }

    @Bean
    public CompactDisc randomBeatlesCD() {

        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0) {
            return new SgtPeppers();
        } else {
            return new WhiteAlbum();
        }
    }
}
