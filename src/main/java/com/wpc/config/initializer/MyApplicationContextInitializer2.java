package com.wpc.config.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

/**
 * ApplicationContextInitializer容器初始化器，用于初始化根web容器
 * 用于在spring容器刷新之前初始化Spring ConfigurableApplicationContext的回调接口
 * 用于需要对应用程序上下文进行编程初始化的web应用程序中。例如，根据上下文环境注册属性源或激活配置文件等
 */
@Order(value = 4)
public class MyApplicationContextInitializer2 implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer2容器初始化器的initialize方法执行了=================");
    }
}
