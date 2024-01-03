package dev.spring.components;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring.components.configuration.Context;
import dev.spring.components.modal.Car;
import dev.spring.components.modal.Truck;

public class App {
    public static void main( String[] args ){
         ApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);

        Car GTR = ctx.getBean(Car.class);
        Car GT = ctx.getBean(Car.class);

        Truck RAM = ctx.getBean(Truck.class);


        System.out.println(GTR.showEngineConfig());
        System.out.println(GT.showEngineConfig());

        System.out.println(RAM.showEngineConfig());

        ((AnnotationConfigApplicationContext)ctx).close();
    }
}
