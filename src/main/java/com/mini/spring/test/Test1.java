package com.mini.spring.test;


import com.mini.spring.context.ClassPathXmlApplicationContextPrimary;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/23 22:14
 */
public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContextPrimary applicationContext = new ClassPathXmlApplicationContextPrimary("beans.xml");
        AService aService = (AService) applicationContext.getBean("aService");
        aService.sayHello();
    }
}
