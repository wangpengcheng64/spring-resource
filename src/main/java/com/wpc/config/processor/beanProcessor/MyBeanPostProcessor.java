package com.wpc.config.processor.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 对象初始化前后的回调
 * spring提供的一个扩展点，通过BeanPostProcessor可以对Spring管理的bean进行再加工
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    // 该方法在bean实例化完毕（且已经注入完毕），在afterPropertiesSet或自定义init方法执行之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("user")){
            System.out.println("========执行MyBeanPostProcessor的postProcessBeforeInitialization方法");
            System.out.println("--------beanName是：" + beanName + "--------");
        }
        return bean;
    }

    // 在afterPropertiesSet或自定义init方法执行之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("user")) {
            System.out.println("执行MyBeanPostProcessor的postProcessAfterInitialization方法========");
        }
        return bean;
    }
}
