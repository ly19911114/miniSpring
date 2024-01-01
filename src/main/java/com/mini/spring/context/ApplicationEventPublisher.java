package com.mini.spring.context;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2024/1/1 16:23
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event)
}
