package dev.spring.dependecyInjection.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.spring.dependecyInjection.modal.Car;
import dev.spring.dependecyInjection.modal.Engine;

@Configuration
public class Context {
    
    @Bean
    public Car getCar() {
        return new Car(getEngine());
    }

    @Bean
    public Engine getEngine(){
        return new Engine();
    }
}
