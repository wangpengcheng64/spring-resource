package com.wpc.config.processor;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

//@Component
public class MyLifecycleProcessor implements SmartLifecycle {

    private volatile boolean isRunning = false;

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
        System.out.println("++++++++：stop");
        isRunning = false;
    }

    @Override
    public void start() {
        System.out.println("++++++++：start");
        isRunning = true;
    }

    @Override
    public void stop() {
        System.out.println("++++++++：stop");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
