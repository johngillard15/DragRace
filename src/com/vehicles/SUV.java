package com.vehicles;

import com.vehicles.engines.Engine;

public class SUV extends Vehicle{

    public SUV(String name, Engine engine) {
        super(name, engine, 3300);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 4) * ((engine.topSpeed + engine.topSpeed/4) - mph) / 10;
        checkSpeed();
    }
}
