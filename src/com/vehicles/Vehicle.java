package com.vehicles;

import com.vehicles.engines.Engine;

public abstract class Vehicle implements Nameable {
    public final String name;
    public final Engine engine;
    public final int weight;
    public final double powerWeightRatio;
    protected int mph;

    public Vehicle(String name, Engine engine, int weight){
        this.name = name;
        this.engine = engine;
        this.weight = weight + engine.weight;
        powerWeightRatio = (double)engine.horsePower / weight;
    }

    public final String getName(){
        return name;
    }

    public final int getMph(){
        return mph;
    }

    public abstract void accelerate();

    public void brake(){
        mph -= Math.sqrt(powerWeightRatio) * (engine.topSpeed - mph) / 10;
        checkSpeed();
    }

    void checkSpeed(){
        if(mph > engine.topSpeed)
            mph = engine.topSpeed;
        else if(mph < 0)
            mph = 0;
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
