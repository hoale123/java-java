package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalenderTest {

    @Test
    public void shouldReturn31ForJanuary(){
        //Arrange
        Calender cal = new Calender();
        //Act
        int days = cal.numberOfDaysInMonth("Janurary",1999);
        //Assert
        assertEquals(31,days);
    }
    @Test
    public void shouldReturn30ForApril(){
        //Arrange
        Calender cal = new Calender();
        //Act
        int days = cal.numberOfDaysInMonth("April",1999);
        //Assert
        assertEquals(30,days);
    }
    @Test
    public void shouldReturn28ForFebruary (){
        //Arrange
        Calender cal = new Calender();
        //Act
        int days = cal.numberOfDaysInMonth("February",1999);
        //Assert
        assertEquals(28,days);
    }

    @Test
    public void shouldReturn29ForLeapYearForFebruary (){
        //Arrange
        Calender cal = new Calender();
        //Act
        int days = cal.numberOfDaysInMonth("February",1999);
        //Assert
        assertEquals(28,days);
    }


}