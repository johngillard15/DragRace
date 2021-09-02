package com.vehicles;

import com.vehicles.engines.Engine;

public class MuscleCar extends Vehicle{

    public MuscleCar(String name, Engine engine) {
        super(name, engine, 3000);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 7) * ((engine.topSpeed + engine.topSpeed/9) - mph) / 10;
        checkSpeed();
    }
}
