package com.mini.spring.beans;


/**
 * 1.获取一个bean
 * 2.注册一个BeanDefinition(registerBeanDefinition)
 *
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/23 23:02
 */
public interface BeanFactory {
    /**
     * 根据bean的名字获取一个bean
     *
     * @param name
     * @return bean
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 注册一个BeanDefinition
     *
     * @param beanDefinition
     */
//    void registerBeanDefinition(BeanDefinition beanDefinition);

//    void registerBean(String name, Object obj);


    boolean containsBean(String name);

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class getType(String name);
}
