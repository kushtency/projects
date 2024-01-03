package dev.spring.components.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// makes this class a bean and put it in the spring context
@Component
public class Car {
    private Engine engine;

    // DI of Engine component from the spring context
    @Autowired
    public Car(@Qualifier("carEngine") Engine engine){
        this.engine = engine;
    }

    public String showEngineConfig(){
        return String.valueOf(this.engine.getHorsePower());
    }

}
