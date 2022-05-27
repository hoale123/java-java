package com.company;

public class Calender {
    // Returns the number of days in a month
    // numberOfDaysInMonth("January",2020) return 31

    public int numberOfDaysInMonth(String monthName, int year){
        if (monthName.equals("April")){
            return 30;
        }     if (monthName.equals("february")) {
            return 28;
        }
        return 31;
    }
}
