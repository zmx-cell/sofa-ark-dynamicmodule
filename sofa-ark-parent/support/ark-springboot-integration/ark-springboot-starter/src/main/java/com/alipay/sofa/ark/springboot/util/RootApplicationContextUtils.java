/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.alipay.sofa.ark.springboot.util;

import com.alipay.sofa.ark.spi.model.Biz;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hanyue
 * @version : RootApplicationContextUtils.java, v 0.1 2022年05月30日 8:53 PM hanyue Exp $
 */
public class RootApplicationContextUtils implements ApplicationContextAware {

    private static final Map<ClassLoader, ApplicationContext> CACHE = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CACHE.put(applicationContext.getClassLoader(), applicationContext);
    }

    public static ApplicationContext getApplicationContext(Biz biz) {
        return getApplicationContext(biz.getBizClassLoader());
    }

    public static ApplicationContext getApplicationContext(ClassLoader classLoader) {
        return CACHE.get(classLoader);
    }
}