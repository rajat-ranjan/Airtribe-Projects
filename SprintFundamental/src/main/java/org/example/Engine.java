package org.example;

public class Engine {

    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showEngineType() {
        System.out.println("Engine type: " + type);
    }
}
