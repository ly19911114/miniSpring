package com.mini.spring.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 管理单例的默认实现类
 * @Author: 刘洋
 * @Date: 2023/12/29 00:24
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    //容器存放所有Bean的名称的列表
    protected List<String> beanNames = new ArrayList<>();
    //容器存放所有bean实例的map
    protected Map<String, Object> singletons = new ConcurrentHashMap<>(256);


    /**
     * 将 singletons 定义为了一个 ConcurrentHashMap，
     * 而且在实现 registrySingleton 时前面加了一个关键字 synchronized。
     * 这一切都是为了确保在多线程并发的情况下，我们仍然能安全地实现对单例 Bean 的管理，
     * 无论是单线程还是多线程，我们整个系统里面这个 Bean 总是唯一的、单例的
     * @param beanName
     * @param singletonObject
     */
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        synchronized (this.singletons){
            this.singletons.put(beanName,singletonObject);
            this.beanNames.add(beanName);
        }
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletons.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return this.singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[]) this.beanNames.toArray();
    }

    protected void removeSingleton(String beanName){
        synchronized (this.singletons){
            this.beanNames.remove(beanName);
            this.singletons.remove(beanName);
        }
    }
}
