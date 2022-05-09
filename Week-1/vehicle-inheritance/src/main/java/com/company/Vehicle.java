package com.company;

import java.util.List;
import java.util.Objects;

public abstract class Vehicle {
    private int topSpeed;
    protected int currentSpeed;
    private String color;
    private String fuelType;
    private boolean sheltered;
    private int personCapacity;
    private List<String> occupants;

    public Vehicle(int topSpeed, String color, String fuelType, boolean sheltered, int personCapacity, List<String> occupants) {
        this.currentSpeed = 0;
        this.topSpeed = topSpeed;
        this.color = color;
        this.fuelType = fuelType;
        this.sheltered = sheltered;
        this.personCapacity = personCapacity;
        this.occupants = occupants;
    }

    public abstract void accelerate(int rate, int duration);

    public void decelerate(int rate, int duration) {
        accelerate(0 - rate, duration);
    }

    // returns true if refuel is successful
    public abstract boolean refuel();

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public List<String> getOccupants() {
        return occupants;
    }

    public void setOccupants(List<String> occupants) {
        this.occupants = occupants;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isSheltered() {
        return sheltered;
    }

    public void setSheltered(boolean sheltered) {
        this.sheltered = sheltered;
    }

    public int getPersonCapacity() {
        return personCapacity;
    }

    public void setPersonCapacity(int personCapacity) {
        this.personCapacity = personCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return topSpeed == vehicle.topSpeed && currentSpeed == vehicle.currentSpeed && sheltered == vehicle.sheltered && personCapacity == vehicle.personCapacity && Objects.equals(color, vehicle.color) && Objects.equals(fuelType, vehicle.fuelType) && Objects.equals(occupants, vehicle.occupants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topSpeed, currentSpeed, color, fuelType, sheltered, personCapacity, occupants);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "topSpeed=" + topSpeed +
                ", currentSpeed=" + currentSpeed +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", sheltered=" + sheltered +
                ", personCapacity=" + personCapacity +
                ", occupants=" + occupants +
                '}';
    }
}