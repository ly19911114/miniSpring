package com.mini.spring.core;

import java.util.Iterator;

/**
 *
 * 外部的配置信息都当成Resource(资源)来进行抽象，比如xml文件、数据库数据等
 *
 * @Description:
 * @Author: 刘洋
 * @Date: 2023/12/23 23:08
 */
public interface Resource extends Iterator<Object> {
}
