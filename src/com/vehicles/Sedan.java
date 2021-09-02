package com.vehicles;

import com.vehicles.engines.Engine;

public class Sedan extends Vehicle{

    public Sedan(String name, Engine engine) {
        super(name, engine, 2600);
    }
}
