package com.wpc.config.initBean;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * 各初始化方法的执行顺序，见spring07.txt源码分析，执行结果：
 *  MyInitializingBean: constructor
 *  MyInitializingBean: postConstruct
 *  MyInitializingBean: afterPropertiesSet
 *  MyInitializingBean: init-method
 */
public class MyInitializingBean implements InitializingBean {

    public MyInitializingBean() {
        System.out.println("MyInitializingBean: constructor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("MyInitializingBean: postConstruct");
    }

    public void initMethod() {
        System.out.println("MyInitializingBean: init-method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean: afterPropertiesSet");
    }
}
