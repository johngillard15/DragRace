package com.vehicles;

import com.vehicles.engines.Engine;

public abstract class Vehicle {
    public final String name;
    public final Engine engine;
    public final int weight;

    public Vehicle(String name, Engine engine, int weight){
        this.name = name;
        this.engine = engine;
        this.weight = weight + engine.weight;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Engine: [%s]
                Total Weight: %,d lbs
                """, name, engine, weight);
    }
}
