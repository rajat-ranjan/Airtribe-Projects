package org.example.annotationbased;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("petrolEngine")
public class PetrolEngine extends Engine {

    public PetrolEngine(@Value("${petrolEngine.type}") String type, @Value("${petrolEngine.make}") String make) {
        super(type, make);
    }

    @Override
    public void showEngineType() {
        System.out.println("Diesel Engine Type: " + getType() + ", Make: " + getMake());
    }
}
