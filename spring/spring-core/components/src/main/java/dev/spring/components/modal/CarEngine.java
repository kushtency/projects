package dev.spring.components.modal;

import org.springframework.stereotype.Component;

// makes this class a bean and put it in the spring context
@Component
public class CarEngine implements Engine{
    private int horsePower = 456;

    public CarEngine(){}
    
    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
}
