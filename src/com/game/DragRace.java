package com.game;

import com.vehicles.DragCar;
import com.vehicles.SUV;
import com.vehicles.SportsCar;
import com.vehicles.Vehicle;
import com.vehicles.engines.Engine;

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
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        Vehicle car = vehicles.get(4);
        double distance = 0;
        double feetPerSec = 1320 / car.getElapsedTime();

        System.out.printf("%s, start your engine...\n", car.name);
        while(distance < 1320){
            distance += feetPerSec;

            if(distance >= 1320)
                System.out.printf("%s has finished the race in %.2f s.\n", car.name, car.getElapsedTime());
            else
                System.out.printf("%s now at %,.2f feet\n", car.name, distance);
        }
    }
}
