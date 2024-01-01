package com.mini.spring.context;

import com.mini.spring.beans.*;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.Resource;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/24 00:53
 */
public class ClassPathXmlApplicationContext implements BeanFactory,ApplicationEventPublisher{
    SimpleBeanFactory beanFactory;

    //context负责整合容器的启动过程，读取外部配置，解析Bean,创建BeanFactory
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(resource);
        this.beanFactory=bf;
    }

    //context再对外提供一个getBean，就是调用的BeanFactory对应的方法
    public Object getBean(String beanName) throws BeansException {
        return beanFactory.getBean(beanName);
    }







    public boolean containsBean(String name){
        return this.beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class getType(String name) {
        return null;
    }

    public void registerBean(String beanName, Object obj) {
        beanFactory.registerBean(beanName,obj);
    }


    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
