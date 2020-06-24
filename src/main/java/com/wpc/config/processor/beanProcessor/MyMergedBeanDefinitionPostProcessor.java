package com.wpc.config.processor.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
     // spring07.txt 作用于修改合并的bean定义
     // 在bean实例化完毕后调用 可以用来修改merged BeanDefinition的一些properties 或者用来给后续回调中缓存一些meta信息使用
     // 这个算是将merged BeanDefinition暴露出来的一个回调
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println(beanName + "：" + beanType + "==================");
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
