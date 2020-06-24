package com.wpc.config.factoryBean;

import com.wpc.bean.Bird;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class BirdFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Bird();
    }

    @Override
    public Class<Bird> getObjectType() {
        return Bird.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
