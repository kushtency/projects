package dev.spring.dependecyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring.dependecyInjection.configuration.Context;
import dev.spring.dependecyInjection.modal.Car;

public class App {
    public static void main( String[] args ){
         ApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);

        Car GTR = ctx.getBean(Car.class);
        Car GT = ctx.getBean(Car.class);

        System.out.println(GTR.showEngineConfig());
        System.out.println(GT.showEngineConfig());


        ((AnnotationConfigApplicationContext)ctx).close();
    }
}
