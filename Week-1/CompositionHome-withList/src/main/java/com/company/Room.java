package com.company;

import java.util.List;
import java.util.Objects;

public class Room {
    private String type;
    private int length;
    private int width;
    private String flooringType;
    private int ceilingHeight;
    List<String> appliances;
    List<String> features;

    public Room(String type, int length, int width, String flooringType, int ceilingHeight, List<String> appliances, List<String> features) {
        this.type = type;
        this.length = length;
        this.width = width;
        this.flooringType = flooringType;
        this.ceilingHeight = ceilingHeight;
        this.appliances = appliances;
        this.features = features;
    }

    public Room() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAppliances() {
        return appliances;
    }

    public void setAppliances(List<String> appliances) {
        this.appliances = appliances;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public int getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(int ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return length == room.length && width == room.width && ceilingHeight == room.ceilingHeight && Objects.equals(flooringType, room.flooringType) && Objects.equals(appliances, room.appliances) && Objects.equals(features, room.features);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, flooringType, ceilingHeight, appliances, features);
    }

    @Override
    public String toString() {
        return "Room{" +
                "length=" + length +
                ", width=" + width +
                ", flooringType='" + flooringType + '\'' +
                ", ceilingHeight=" + ceilingHeight +
                ", appliances=" + appliances +
                ", features=" + features +
                ", type='" + type + '\'' +
                '}';
    }
}
