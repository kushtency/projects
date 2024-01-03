package dev.spring.components.modal;

import org.springframework.stereotype.Component;

@Component
public class TruckEngine implements Engine{
    private int horsePower = 782;

    public TruckEngine(){}
    
    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
}
