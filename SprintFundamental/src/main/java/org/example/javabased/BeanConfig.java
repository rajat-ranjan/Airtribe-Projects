package org.example.javabased;

import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public Engine engine() {
        return new Engine("V8");
    }
/*
    @Bean
    public Engine engine1() {
        return new Engine("Turbo Engine");
    }*/

    @Bean
    public Car car(Engine engine, String carType) {
        return new Car(engine, carType);
    }
}
