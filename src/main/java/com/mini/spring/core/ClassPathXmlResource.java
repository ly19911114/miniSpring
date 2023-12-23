package com.mini.spring.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *单一职责：解析XML文件
 * @Description:目前数据来源比较单一，只有xml文件，但有了Resource接口，可以扩展为从数据库、网络等获取配置信息
 * @Author: 刘洋
 * @Date: 2023/12/23 23:19
 */
public class ClassPathXmlResource implements Resource{
    Document document;
    Element rootElement;
    Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        try {
            //将配置文件装载进来，生成一个迭代器。用于遍历元素
            this.document = saxReader.read(xmlPath);
            this.rootElement = document.getRootElement();
            this.elementIterator = this.rootElement.elementIterator();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    @Override
    public Object next() {
        return this.elementIterator.next();
    }


}
