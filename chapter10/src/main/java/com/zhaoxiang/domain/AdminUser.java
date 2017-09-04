package com.zhaoxiang.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author: Rivers
 * Date: 2017/9/5 06:53
 */
@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
