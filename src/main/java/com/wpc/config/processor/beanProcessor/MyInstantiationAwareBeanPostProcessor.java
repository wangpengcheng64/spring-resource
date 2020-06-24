package com.wpc.config.processor.beanProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    // 这个方法用来在对象实例化前直接返回一个对象（如代理对象）来代替通过内置的实例化流程创建对象；缩短bean实例的创建流程
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    // 在对象实例化完毕执行populateBean之前 如果返回false则spring不再对对应的bean实例进行自动依赖注入。
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    // 这里是在spring处理完默认的成员属性，应用到指定的bean之前进行回调，可以用来检查和修改属性，最终返回的PropertyValues会应用到bean中
    // @Autowired、@Resource等就是根据这个回调来实现最终注入依赖的属性的。
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (beanName.contains("user")){
            System.out.println("========执行MyInstantiationAwareBeanPostProcessor的postProcessPropertyValues方法");
        }
        return pvs;
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
