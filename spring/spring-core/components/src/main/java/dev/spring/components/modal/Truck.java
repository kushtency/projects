package dev.spring.components.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Truck {
    private Engine engine;

    // DI of Engine component from the spring context
    // if there are 2 beans refering to the same factory or interface
    // use qualifier
    @Autowired
    public Truck(@Qualifier("truckEngine") Engine engine){
        this.engine = engine;
    }

    public String showEngineConfig(){
        return String.valueOf(this.engine.getHorsePower());
    }
}