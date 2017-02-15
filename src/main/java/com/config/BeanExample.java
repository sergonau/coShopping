package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanExample {

    private String name;

    @Bean(name = "test")
    BeanExample createBeanExample(){
        BeanExample beanExample = new BeanExample();
        beanExample.setName("111");
        return beanExample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
