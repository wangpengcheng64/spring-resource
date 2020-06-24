package com.wpc.config.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class MyAware implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(classLoader.getClass().getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getClass().getName());
    }

}
