package com.vehicles.engines;

public abstract class Engine {
    public final String name;
    public final int horsePower;
    public final int weight;
    protected boolean isOn;

    public Engine(String name, int horsePower, int weight){
        this.name = name;
        this.horsePower = horsePower;
        this.weight = weight;
        isOn = false;
    }

    protected void start(){
        isOn = true;
    }

    protected void stop(){
        isOn = false;
    }

    public int getHorsePower(){
        return horsePower;
    }
}
