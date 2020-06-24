package com.wpc.config.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MyApplicationContextEvent extends ApplicationContextEvent {
    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that the event is raised for
     *               (must not be {@code null})
     */
    public MyApplicationContextEvent(ApplicationContext source) {
        super(source);
        System.out.println("发布了我的事件====================");
    }
}
