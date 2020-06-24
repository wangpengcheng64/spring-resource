package com.wpc.config.processor.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    // 作用于Bean的销毁
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (beanName.contains("user")) {
            System.out.println("========执行MyDestructionAwareBeanPostProcessor的销毁方法postProcessBeforeDestruction！！！");
        }
    }

    // 判断是否需要处理这个对象的销毁
    @Override
    public boolean requiresDestruction(Object bean) {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
