package com.mini.spring.beans;

import lombok.Data;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/23 21:18
 */
@Data
public class BeanDefinition {

    private String id;

    private String className;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }
}
