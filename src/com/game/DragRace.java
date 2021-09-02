package com.game;

import com.utilities.Input;
import com.utilities.UI;
import com.vehicles.*;
import com.vehicles.engines.Engine;
import com.vehicles.engines.FourCylinder;
import com.vehicles.engines.V12;
import com.vehicles.engines.V8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DragRace {
    private final List<Vehicle> vehicles = new ArrayList<>();
    public static final int QUARTER_MILE = 1320;
    public static final String[] VEHICLE_TYPES = {
            "Drag build",
            "Muscle",
            "Sedan",
            "Sport",
            "Super",
            "SUV"
    };
    public static final String[] ENGINE_TYPES = {
            "Four Cylinder",
            "V8",
            "V12"
    };

    public DragRace(){
        Engine engine;

        engine = new V8("Tuned V8", 1200, 270);
        vehicles.add(new DragCar("Drag Car", engine));

        engine = new V8("5.0L V8", 450, 160);
        vehicles.add(new MuscleCar("Muscle Car", engine));

        engine = new V12("V12", 660, 214);
        vehicles.add(new SuperCar("Super Car", engine));

        engine = new FourCylinder("2.0L 4-cylinder", 150, 143);
        vehicles.add(new Sedan("Family Sedan", engine));

        engine = new V8("6.2L V8", 270, 130);
        vehicles.add(new SUV("SUV", engine));

        engine = new FourCylinder("2.5L flat-four", 310, 174);
        vehicles.add(new Sedan("Sport Sedan", engine));
    }

    public Vehicle buildCar(){
        System.out.println("\nSelect a vehicle type:");
        UI.listerator(VEHICLE_TYPES);
        int vehicleType = Input.getInt(1, VEHICLE_TYPES.length);

        System.out.println("\nSelect an engine type:");
        UI.listerator(ENGINE_TYPES);
        int engineType = Input.getInt(1, ENGINE_TYPES.length);
        System.out.println("Enter horsepower:");
        int hp = Input.getInt(0);
        System.out.println("Enter top speed:");
        int topSpeed = Input.getInt(0);

        System.out.println("\nGive your vehicle a name:");
        String name = Input.getString();

        Engine engine = switch(engineType){
            case 1 -> new FourCylinder("Custom", hp, topSpeed);
            case 2 -> new V8("Custom", hp, topSpeed);
            case 3 -> new V12("Custom", hp, topSpeed);

            default -> throw new IllegalStateException("Invalid Engine type: " + engineType);
        };

        return switch(vehicleType){
            case 1 -> new DragCar(name, engine);
            case 2 -> new MuscleCar(name, engine);
            case 3 -> new Sedan(name, engine);
            case 4 -> new SportsCar(name, engine);
            case 5 -> new SuperCar(name, engine);
            case 6 -> new SUV(name, engine);

            default -> throw new IllegalStateException("Invalid Vehicle type: " + vehicleType);
        };
    }

    public void run(){
        System.out.println("Do you want to build your own car or select a pre-built?");
        UI.listerator("Show Pre-built Cars", "Build Custom Car");

        Vehicle car = switch(Input.getInt(1,2)){
            case 1 -> {
                System.out.println("\nWhat car would you like to drive?");

                String[] vehicleNames = vehicles.stream()
                        .map(Vehicle::getName)
                        .collect(Collectors.toList())
                        .toArray(new String[vehicles.size()])
                        ;

                UI.listerator(vehicleNames);
                int choice = Input.getInt(1, vehicles.size()) - 1;

                yield vehicles.get(choice);
            }
            case 2 -> buildCar();

            default -> throw new IllegalStateException("Unexpected value: " + "");
        };

        int distance = 0;
        double time = 0;
        do{
            System.out.printf("\nSpeed: %d mph\tDistance Travelled: %d ft\tTime: %.2f s\n", car.getMph(), distance, time);
            System.out.println("What would you like to do?");
            UI.listerator("accelerate", "cruise", "brake");

            switch(Input.getInt(1, 3)){
                case 1 -> {
                    System.out.println("Speeding up...");
                    car.accelerate();
                }

                case 2 -> System.out.println("Maintaining Speed...");

                case 3 -> {
                    System.out.println("Slowing down...");
                    car.brake();
                }
            }

            distance += car.getMph() * (22.0 / 15.0); // mph to feet per second; 5280 / 3600 = 22 / 15
            ++time;
        }while(distance < QUARTER_MILE);

        double fps = (double)car.getMph() * (22.0 / 15.0);
        double overTime = (distance - QUARTER_MILE) / fps;
        double trapSpeed = car.getMph() + (1 - overTime) * fps / 88; // fps to mph; 5280 / 60 = 88
        if(trapSpeed > car.engine.topSpeed) trapSpeed = car.engine.topSpeed;

        System.out.printf("\nYou have finished the race in %.2f seconds with a trap speed of %.2f mph.",
                time - overTime, trapSpeed);
    }
}
