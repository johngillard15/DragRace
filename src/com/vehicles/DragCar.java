package com.vehicles;

import com.vehicles.engines.Engine;

public class DragCar extends Vehicle {

    public DragCar(String name, Engine engine, int weight) {
        super(name, engine, weight, 0.1);
    }
}
