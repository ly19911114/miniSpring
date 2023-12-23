package com.mini.spring.beans;

import com.mini.spring.core.Resource;
import lombok.AllArgsConstructor;
import org.dom4j.Element;

/**
 * @Description:将解析好的xml文件转换为BeanDefinition 注册到BeanFactory中
 * @Author: 刘洋
 * @Date: 2023/12/24 00:05
 */

public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;
    /**
     * 构造函数
     * @param beanFactory
     */
    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    /**
     * 将xml文件转换为BeanDefinition 注册到BeanFactory中
     * @param resource
     */
    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()){
            Element element= (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID,beanClassName);
            beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
