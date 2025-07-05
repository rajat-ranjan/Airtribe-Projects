package org.example.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        Engine engine1 = applicationContext.getBean("engine", Engine.class);
//        Engine engine2 = applicationContext.getBean("engine1", Engine.class);

        engine1.showEngineType();
//        engine2.showEngineType();

        Car car1 = applicationContext.getBean("car", Car.class);

        car1.drive();
    }
}
