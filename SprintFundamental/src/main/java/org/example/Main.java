package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Engine engine1 = applicationContext.getBean("engine1", Engine.class);
        Engine engine2 = applicationContext.getBean("engine2", Engine.class);

        engine1.showEngineType();
        engine2.showEngineType();

        Car car1 = applicationContext.getBean("car1", Car.class);
        Car car2 = applicationContext.getBean("car2", Car.class);

        car1.drive();
        car2.drive();

    }
}