package com.mini.spring.context;

import com.mini.spring.beans.*;
import com.mini.spring.core.ClassPathXmlResource;
import com.mini.spring.core.Resource;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/24 00:53
 */
public class ClassPathXmlApplicationContext {
    BeanFactory beanFactory;

    //context负责整合容器的启动过程，读取外部配置，解析Bean,创建BeanFactory
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        BeanFactory bf = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(resource);
        this.beanFactory=bf;
    }

    //context再对外提供一个getBean，就是调用的BeanFactory对应的方法
    public Object getBean(String beanName) throws BeansException {
        return beanFactory.getBean(beanName);
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanFactory.registerBeanDefinition(beanDefinition);
    }

}
