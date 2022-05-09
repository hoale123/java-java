package com.company.play;

import com.company.Car;
import com.company.Helicopter;

import java.util.ArrayList;

public class GameEngine {
    public static void main(String[] args) {
        Car newCar = new Car(135, "silver", 5, new ArrayList<String>(), "Subaru", "Outback", 2019);

        Car secondCar = new Car(180, "gray", 4, new ArrayList<String>(), "Toyota", "Corolla", 2020);
        //    public Car(int topSpeed, String color, int personCapacity, List<String> occupants, String make, String model, int modelYear) {

        Helicopter helyeah = new Helicopter(200, true, 4, new ArrayList<String>(), 3300);

//        Vehicle vehicle = new Vehicle()

        System.out.println(newCar.honk(10));
        helyeah.refuel();
        secondCar.accelerate(14, 3);
        System.out.println(secondCar.honk(1));
    }
}