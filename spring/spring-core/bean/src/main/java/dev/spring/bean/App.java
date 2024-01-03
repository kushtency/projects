package dev.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.spring.bean.config.Context;
import dev.spring.bean.modal.Car;
import dev.spring.bean.modal.SuperCar;

public class App {
    public static void main( String[] args ){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Context.class);

        Car GTR = ctx.getBean(Car.class);
        Car GT = ctx.getBean(Car.class);
        SuperCar P1 = ctx.getBean(SuperCar.class);
        SuperCar ZONDA = ctx.getBean(SuperCar.class);

        // returns same instance i.e. Singleton
        System.out.println(GTR);
        System.out.println(GT);

        // returns different instance whenever context return a new bean
        System.out.println(P1);
        System.out.println(ZONDA);

        ((AnnotationConfigApplicationContext)ctx).close();
    }
}
