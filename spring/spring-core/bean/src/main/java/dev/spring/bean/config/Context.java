package dev.spring.bean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dev.spring.bean.modal.Car;
import dev.spring.bean.modal.SuperCar;

@Configuration
public class Context {
    
    // by default singleton
    // can be specify by @Scope("singleton")
    @Bean
    public Car getCar() {
        return new Car();
    }

    @Bean
    @Scope("prototype")
    public SuperCar getSuperCar() {
        return new SuperCar();
    }

}
