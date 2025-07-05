package org.example.annotationbased;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    private String carType;

    public Car(@Qualifier("disealEngine") Engine engine, @Value("${car.carType}") String carType) {
        this.engine = engine;
        this.carType = carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void drive() {
        engine.showEngineType();
        System.out.println("Driving a " + carType + " with " + engine.getType() + " engine.");
    }
}
