package com.mini.spring.beans;

/**
 * @Description:管理单例 Bean 的方法规范
 * @Author: 刘洋
 * @Date: 2023/12/29 00:15
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName,Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();
}
