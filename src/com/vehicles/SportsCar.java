package com.vehicles;

import com.vehicles.engines.Engine;

public class SportsCar extends Vehicle {

    public SportsCar(String name, Engine engine) {
        super(name, engine, 2200);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 10) * ((engine.topSpeed + engine.topSpeed/10) - mph) / 10;
        checkSpeed();
    }
}
