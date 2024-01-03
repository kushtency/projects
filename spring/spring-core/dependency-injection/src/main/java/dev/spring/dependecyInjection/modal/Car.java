package dev.spring.dependecyInjection.modal;

public class Car {
    // DI of Engine
    private Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public String showEngineConfig(){
        return String.valueOf(this.engine.getHorsePower());
    }

}
