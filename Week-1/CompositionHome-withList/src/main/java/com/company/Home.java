package com.company;

import java.util.List;
import java.util.Objects;

public class Home {
   String owner;
   double totalSqFeet;
   String slidingType;
   String roofType;
   int listingprice;
   String schoolDistrict;
   List<Room> rooms;

    public Home(String owner, double totalSqFeet, String slidingType, String roofType, int listingprice, String schoolDistrict, List<Room> rooms) {
        this.owner = owner;
        this.totalSqFeet = totalSqFeet;
        this.slidingType = slidingType;
        this.roofType = roofType;
        this.listingprice = listingprice;
        this.schoolDistrict = schoolDistrict;
        this.rooms = rooms;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getTotalSqFeet() {
        return totalSqFeet;
    }

    public void setTotalSqFeet(double totalSqFeet) {
        this.totalSqFeet = totalSqFeet;
    }

    public String getSlidingType() {
        return slidingType;
    }

    public void setSlidingType(String slidingType) {
        this.slidingType = slidingType;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public int getListingprice() {
        return listingprice;
    }

    public void setListingprice(int listingprice) {
        this.listingprice = listingprice;
    }

    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    public void setSchoolDistrict(String schoolDistrict) {
        this.schoolDistrict = schoolDistrict;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Double.compare(home.totalSqFeet, totalSqFeet) == 0 && listingprice == home.listingprice && Objects.equals(owner, home.owner) && Objects.equals(slidingType, home.slidingType) && Objects.equals(roofType, home.roofType) && Objects.equals(schoolDistrict, home.schoolDistrict) && Objects.equals(rooms, home.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, totalSqFeet, slidingType, roofType, listingprice, schoolDistrict, rooms);
    }

    @Override
    public String toString() {
        return "Home{" +
                "owner='" + owner + '\'' +
                ", totalSqFeet=" + totalSqFeet +
                ", slidingType='" + slidingType + '\'' +
                ", roofType='" + roofType + '\'' +
                ", listingprice=" + listingprice +
                ", schoolDistrict='" + schoolDistrict + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
