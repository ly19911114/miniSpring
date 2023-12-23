package com.mini.spring.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 实现BeanFactory接口，用懒加载的方式获取Bean
 * @Author: 刘洋
 * @Date: 2023/12/24 00:17
 */
public class SimpleBeanFactory implements BeanFactory {
    //存放BeanDefinition的集合
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    //存放bean的名字
    private List<String> beanNames = new ArrayList<>();
    private Map<String, Object> signletons = new HashMap<>();

    public SimpleBeanFactory() {

    }

    //getBean，容器核心方法,懒加载
    @Override
    public Object getBean(String beanName) throws BeansException {
        //先尝试直接拿Bean实例
        Object singleton = signletons.get(beanName);
        //如果此时还没有这个Bean实例，则获取它的定义来创建实例
        if (singleton == null) {
            int i = beanNames.indexOf(beanName);
            if (i == -1) {
                throw new BeansException("没有找到" + beanName + "的Bean定义");
            } else {
                //获取Bean的定义
                BeanDefinition beanDefinition = beanDefinitions.get(i);
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                    //注册Bean实例
                    signletons.put(beanName, singleton);
                } catch (Exception e) {
                    throw new BeansException("Bean实例化异常");
                }
            }
        }
        return singleton;

    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanDefinitions.add(beanDefinition);
        this.beanNames.add(beanDefinition.getId());
    }
}
