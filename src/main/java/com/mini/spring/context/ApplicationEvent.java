package com.mini.spring.context;

import java.util.EventObject;

/**
 * @Description:
 * @Author: 刘洋
 * @Date: 2024/1/1 16:15
 */
public class ApplicationEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
