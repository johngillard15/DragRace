package com.vehicles.engines;

import com.vehicles.Nameable;

public abstract class Engine implements Nameable {
    public final String name;
    public final int horsePower;
    public final int weight;
    public final int topSpeed;
    protected boolean isOn;

    public Engine(String name, int horsePower, int weight, int topSpeed){
        this.name = name;
        this.horsePower = horsePower;
        this.weight = weight;
        this.topSpeed = topSpeed;
        isOn = false;
    }

    protected void start(){
        isOn = true;
    }

    protected void stop(){
        isOn = false;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Horsepower: %,d, Weight: %,d lbs, Top Speed: %d mph",
                name, horsePower, weight, topSpeed);
    }
}
