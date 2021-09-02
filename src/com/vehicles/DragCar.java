package com.vehicles;

import com.vehicles.engines.Engine;

public class DragCar extends Vehicle {

    public DragCar(String name, Engine engine) {
        super(name, engine, 1800);
    }

    @Override
    public void accelerate(){
        mph += Math.sqrt(powerWeightRatio * 10) * ((engine.topSpeed + engine.topSpeed/6) - mph) / 10;
        checkSpeed();
    }
}
