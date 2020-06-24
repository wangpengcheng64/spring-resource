package com.wpc.config.initBean;

import com.wpc.bean.Bird;
import com.wpc.bean.Fish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutowireBean {

    private Bird bird;

    private Fish fish;

    public AutowireBean() {
    }

    public AutowireBean(Bird bird) {
        this.bird = bird;
    }

    @Autowired
    public AutowireBean(Bird bird, Fish fish) {
        this.bird = bird;
        this.fish = fish;
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }
}
