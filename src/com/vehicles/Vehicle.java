package com.vehicles;

import com.vehicles.engines.Engine;

public abstract class Vehicle {
    public final String name;
    public final Engine engine;
    public final int weight;
    private final int trapSpeed;

    public Vehicle(String name, Engine engine, int weight){
        this.name = name;
        this.engine = engine;
        this.weight = weight + engine.weight;
        // https://www.calculator.net/engine-horsepower-calculator.html
        trapSpeed = (int)Math.cbrt((double)engine.getHorsePower() / (double)weight) * 234;
    }

    public abstract void drag();
}
