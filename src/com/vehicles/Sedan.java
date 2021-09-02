package com.vehicles;

import com.vehicles.engines.Engine;

public class Sedan extends Vehicle{

    public Sedan(String name, Engine engine) {
        super(name, engine, 2600);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 5) * ((engine.topSpeed + engine.topSpeed/5) - mph) / 10;
        checkSpeed();
    }
}
