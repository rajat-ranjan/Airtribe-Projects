package org.example.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Engine engine1 = applicationContext.getBean("petrolEngine", Engine.class);
        engine1.showEngineType();

        Engine engine2 = applicationContext.getBean("disealEngine", Engine.class);
        engine2.showEngineType();

        System.out.println("=====================================");


        Car car1 = applicationContext.getBean(Car.class);
        car1.drive();

    }
}
