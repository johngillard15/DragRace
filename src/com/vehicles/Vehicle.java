package com.vehicles;

import com.vehicles.engines.Engine;

public abstract class Vehicle {
    public final String name;
    public final Engine engine;
    public final int weight;
    protected double trapSpeed;
    protected double dragCoefficient;

    public Vehicle(String name, Engine engine, int weight, double dragCoefficient){
        this.name = name;
        this.engine = engine;
        this.weight = weight + engine.weight;
        this.dragCoefficient = dragCoefficient;

        calculateTrapSpeed();
    }

    public double getTrapSpeed(){
        return trapSpeed;
    }

    protected void setTrapSpeed(double trapSpeed){
        this.trapSpeed = trapSpeed;
    }

    protected void calculateTrapSpeed(){
        // https://www.calculator.net/engine-horsepower-calculator.html
        trapSpeed = Math.cbrt((double)engine.horsePower / (double)weight) * 234;
    }

    protected void calculateDrag() {
        double adjustedSpeed = trapSpeed - trapSpeed * dragCoefficient;
        setTrapSpeed(adjustedSpeed);
    }

    @Override
    public String toString() {
        return String.format("""
                Name: %s
                Engine: [%s]
                Total Weight: %,d lbs
                Trap Speed (1/4 mile): %.2f mph
                Drag Coefficient: %.2f
                """, name, engine, weight, trapSpeed, dragCoefficient);
    }
}
