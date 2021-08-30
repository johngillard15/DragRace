package com.vehicles;

import com.vehicles.engines.Engine;

public abstract class Vehicle {
    public final String name;
    public final Engine engine;
    public final int weight;
    protected double trapSpeed;
    protected double elapsedTime;
    public int speed = 0;
    protected int brakingDistance;

    public Vehicle(String name, Engine engine, int weight){
        this.name = name;
        this.engine = engine;
        this.weight = weight + engine.weight;

        calculateTrapSpeed();
        calculateElapsedTime();
        speed += 1320 / (int)elapsedTime;
        setBrakingDistance();
    }

    protected void calculateTrapSpeed(){
        // Hale equation
        trapSpeed = Math.cbrt((double)engine.horsePower / (double)weight) * 234;
    }

    protected void calculateElapsedTime(){
        // Hale equation
        elapsedTime = Math.cbrt((double)weight / (double)engine.horsePower) * 5.825;
    }

    public double getTrapSpeed(){
        return trapSpeed;
    }

    public double getElapsedTime() {
        return elapsedTime;
    }

    public int getSpeed(){
        return speed;
    }


    public int getBrakingDistance(){
        return brakingDistance;
    }

    public void setBrakingDistance() {
        brakingDistance = (int)Math.sqrt(trapSpeed / 10);
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Engine: [%s]
                Total Weight: %,d lbs
                Trap Speed (1/4 mile): %.2f mph
                Elapsed Time (1/4): %.2f s
                """, name, engine, weight, trapSpeed, elapsedTime);
    }
}
