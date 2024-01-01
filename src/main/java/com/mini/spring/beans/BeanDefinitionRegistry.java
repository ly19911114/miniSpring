package com.mini.spring.beans;

/**
 * @Description:存放 BeanDefinition 的仓库，可以存放、移除、获取及判断 BeanDefinition 对象
 * @Author: 刘洋
 * @Date: 2024/1/1 17:25
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition bd);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
