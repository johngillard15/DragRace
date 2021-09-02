package com.vehicles;

import com.vehicles.engines.Engine;

public class SuperCar extends Vehicle{

    public SuperCar(String name, Engine engine) {
        super(name, engine, 2000);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 5) * ((engine.topSpeed + engine.topSpeed/2) - mph) / 10;
        checkSpeed();
    }
}
