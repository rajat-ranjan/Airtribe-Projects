package org.example.annotationbased;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("disealEngine")
public class DisealEngine extends Engine {

    public DisealEngine(@Value("${disealEngine.type}") String type,@Value("${disealEngine.make}") String make) {
        super(type, make);
    }

    @Override
    public void showEngineType() {
        System.out.println("Diesel Engine Type: " + getType() + ", Make: " + getMake());
    }
}
