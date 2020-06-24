package com.wpc.myApp;

import com.wpc.bean.User;
import com.wpc.config.processor.beanFactoryProcessor.ManualBeanFactoryPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext extends ClassPathXmlApplicationContext {

    public MyApplicationContext(String configLocation) {
        super(configLocation);
    }

    @Override
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        this.addBeanFactoryPostProcessor(new ManualBeanFactoryPostProcessor());
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("================:" + beanDefinitionName);
        }
    }

    @Override
    protected void onRefresh() throws BeansException {
        System.out.println("执行了onRefresh()方法~~~~~~~~~~~~~~");
        User user = new User();
        this.getBeanFactory().registerSingleton("userTest", user);
    }

}
