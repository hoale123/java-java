package com.company;

import java.util.List;
import java.util.Objects;

public class Helicopter extends Vehicle {
    private int weightCapacity;
    private String bladeConfiguration;

    public Helicopter(int topSpeed, boolean sheltered, int personCapacity, List<String> occupants, int weightCapacity) {
        super(topSpeed, "black", "chopper fuel", sheltered, personCapacity, occupants);
        this.weightCapacity = weightCapacity;
        this.bladeConfiguration = "Four right angles";
    }

    public int getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public String getBladeConfiguration() {
        return bladeConfiguration;
    }

    public void setBladeConfiguration(String bladeConfiguration) {
        this.bladeConfiguration = bladeConfiguration;
    }

    @Override
    public void accelerate(int rate, int duration) {
        System.out.println("Making a loud chopper sound now.");
        System.out.println("We need a direction of acceleration, assuming up");
        setCurrentSpeed(getCurrentSpeed() + rate * duration);
    }

    @Override
    public boolean refuel() {
        System.out.println("Special chopper fuel.");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Helicopter that = (Helicopter) o;
        return weightCapacity == that.weightCapacity && Objects.equals(bladeConfiguration, that.bladeConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weightCapacity, bladeConfiguration);
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "weightCapacity=" + weightCapacity +
                ", bladeConfiguration='" + bladeConfiguration + '\'' +
                '}';
    }
}