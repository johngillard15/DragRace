package com.game;

import com.utilities.Input;
import com.vehicles.DragCar;
import com.vehicles.SUV;
import com.vehicles.SportsCar;
import com.vehicles.Vehicle;
import com.vehicles.engines.Engine;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class DragRace {
    private List<Vehicle> vehicles = new ArrayList<>();

    public DragRace(){
        Engine nitromethane = new Engine("Nitromethane", 10_000, 505);
        Vehicle topFuel = new DragCar("Top Fuel Dragster", nitromethane, 1850);

        Engine twoZZ = new Engine("2ZZ", 257, 275);
        Vehicle lotusExige = new SportsCar("Lotus Exige", twoZZ, 2110);

        Engine hemiV8 = new Engine("6.2L HEMI SRT Hellcat V8", 710, 500);
        Vehicle dodgeDurango = new SUV("Dodge Durango SRT Hellcat", hemiV8, 5210);

        Engine MR6V8 = new Engine("Porsche MR6 V8", 887, 298);
        Vehicle porsche918 = new SportsCar("Porsche 918 Spyder", MR6V8, 3491);

        Engine demonV8 = new Engine("6.2-liter V8", 840, 500);
        Vehicle dodgeDemon = new SUV("Dodge Challenger SRT Demon", demonV8, 3780);

        vehicles.add(topFuel);
        vehicles.add(lotusExige);
        vehicles.add(dodgeDurango);
        vehicles.add(porsche918);
        vehicles.add(dodgeDemon);
    }

    public void run(){
//        for(Vehicle vehicle : vehicles){
//            System.out.println(vehicle);
//        }

        System.out.println("Which car would you like to drive?");
        int listNum = 0;
        for(Vehicle vehicle : vehicles)
            System.out.printf("%d. %s\n", ++listNum, vehicle.name);
        int choice = Input.getInt(1, vehicles.size()) - 1;

        Vehicle car = vehicles.get(choice);
        int distance = 0;
        int turnSpeed = (int)(car.getSpeed() / car.getElapsedTime());
        int currentSpeed = 0;
        double totalTime = 0;

        System.out.printf("\n%s, start your engine...\n", car.name);
        while(distance < 1320){
            System.out.println("What would you like to do?");
            System.out.println("1. accelerate");
            System.out.println("2. coast");
            System.out.println("3. brake");
            choice = Input.getInt(1, 3);

            switch(choice){
                case 1 -> {
                    System.out.println("Speeding up...");
                    currentSpeed += turnSpeed;
                    totalTime += car.getSpeed();
                }
                case 2 -> {
                    System.out.println("Maintaining speed...");
                    totalTime += car.getElapsedTime() / car.getSpeed(); // FIXME: 8/30/2021 get real time
                }
                case 3 -> {
                    System.out.println("Slowing down...");

                    currentSpeed -= turnSpeed;
                    if(currentSpeed < 0)
                        currentSpeed = 0;
                    totalTime += car.getElapsedTime() / car.getSpeed();
                }
            }

            distance += currentSpeed;

            if(distance >= 1320)
                System.out.printf("\n%s has finished the race in %.2f s.\n", car.name, totalTime);
            else {
                System.out.printf("\nCurrent speed: %d mph", currentSpeed);
                System.out.printf("\n%s now at %,d feet\n", car.name, distance);
            }
        }

        System.out.println("Now braking...");
        double brakingTime = car.getTrapSpeed() / car.getBrakingDistance();
        System.out.printf("%s has stopped in %.2f s.\n", car.name, brakingTime);
    }
}
