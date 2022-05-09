package com.company;

import java.util.List;
import java.util.Objects;

public class Car extends Vehicle {
    private int doorCount;
    private String make;
    private String model;
    private int modelYear;

    public Car(int topSpeed, String color, int personCapacity, List<String> occupants, String make, String model, int modelYear) {
        super(topSpeed, color, "gasoline", true, personCapacity, occupants);
        this.doorCount = 4;
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
    }

    @Override
    public void accelerate(int rate, int duration) {
        this.currentSpeed = this.currentSpeed + rate * duration;
    }

    @Override
    public boolean refuel() {
        System.out.println("Gassing up.");
        return true;
    }

    public String honk(int duration) {
        if (duration == 1) {
            return "beep!";
        } else {
            return "Hoooooooonnnnnk!";
        }
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return doorCount == car.doorCount && modelYear == car.modelYear && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), doorCount, make, model, modelYear);
    }

    @Override
    public String toString() {
        return "Car{" +
                "doorCount=" + doorCount +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", modelYear=" + modelYear +
                '}';
    }
}