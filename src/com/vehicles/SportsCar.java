package com.vehicles;

import com.vehicles.engines.Engine;

public class SportsCar extends Vehicle {

    public SportsCar(String name, Engine engine, int weight) {
        super(name, engine, weight, 0.2);
    }
}
