package org.example.annotationbased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Engine {
    private String type;
    private String make;

    public Engine(String type, String make) {
        this.type = type;
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showEngineType() {
        System.out.println("Engine Type: " + type + ", Make: " + make);
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}
