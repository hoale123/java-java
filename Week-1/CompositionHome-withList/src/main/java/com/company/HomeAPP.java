package com.company;

import java.util.ArrayList;
import java.util.List;

public class HomeAPP {
    public static void main(String[] args) {

        List<Room> myRooms = new ArrayList<>();
        List<String> kitchenAppliances = new ArrayList<>();
        List<String> kitchenFeatures = new ArrayList<>();
        kitchenAppliances.add("Refrigerator");
        kitchenAppliances.add("Stove");
        kitchenAppliances.add("Table");
        kitchenFeatures.add("Bar");
        kitchenFeatures.add("Cool Stuff");
        Room myKitchen = new Room("Kitchen", 10, 10, "wood", 10, kitchenAppliances, kitchenFeatures);
        myRooms.add(myKitchen);
        Home home = new Home("Hoa", 20, "Metal", "wood", 200000, "Dekablb", myRooms);
        System.out.println(home);
        System.out.println(myRooms);
        System.out.println(myKitchen);
    }
}
