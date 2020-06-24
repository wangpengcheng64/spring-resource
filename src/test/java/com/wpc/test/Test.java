package com.wpc.test;

import com.wpc.config.event.MyApplicationContextEvent;
import com.wpc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-*.xml");
//        ApplicationContext context = new MyApplicationContext("/spring/spring-*.xml");
        context.publishEvent(new MyApplicationContextEvent(context));
        UserService userService = context.getBean(UserService.class);
        Object bird = context.getBean("autowireBean");
        System.out.println(bird);
        System.out.println(userService.getUserById(1L).toString());
        context.close();
    }

}
