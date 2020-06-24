package com.wpc.config.factoryBean;

import com.wpc.bean.Fish;
import org.springframework.beans.factory.SmartFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FishSmartFactoryBean implements SmartFactoryBean {
    @Override
    public boolean isPrototype() {
        return false;
    }

    @Override
    public boolean isEagerInit() {
        return true;
    }

    @Override
    public Object getObject() throws Exception {
        return new Fish();
    }

    @Override
    public Class<?> getObjectType() {
        return Fish.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
