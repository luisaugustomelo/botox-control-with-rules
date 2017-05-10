package com.medicine.control.json.handler;

public class Sensor {
    private Integer temperature;

    // Getters and setters are not required for this example.
    // GSON sets the fields directly using reflection.

    @Override
    public String toString() {
        return ""+temperature;
    }
}