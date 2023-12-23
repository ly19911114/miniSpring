package com.mini.spring.context;

import com.mini.spring.beans.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1.解析xml文件中的内容
 * 2.加载解析的内容，构建BeanDefinition对象
 * 3.读取BeanDefinition对象，实例化Bean
 *
 * @Description:初级IOC容器
 * @Author: 刘洋
 * @Date: 2023/12/23 21:28
 */
public class ClassPathXmlApplicationContextPrimary {

    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String, Object> sigletons = new HashMap<>();

    //构造器获取外部配置，解析出Bean的定义，形成内存映像
    public ClassPathXmlApplicationContextPrimary(String fileName) {
        this.readXML(fileName);
        this.instanceBeans();
    }

    private void readXML(String fileName) {
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            //对配置文件中的每一个bean进行解析
            for (Element element : (List<Element>) rootElement.elements()) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(id, className);
                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //利用反射机制，实例化Bean,并放入到sigletons中
    private void instanceBeans() {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
//                String className = beanDefinition.getClassName();
//                Class<?> clazz = Class.forName(className);
//                Object bean = clazz.newInstance();
//                sigletons.put(beanDefinition.getId(),bean);
                sigletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //提供getBean方法，根据beanName从sigletons中获取bean实例
    public Object getBean(String beanName) {
        return sigletons.get(beanName);
    }
}
