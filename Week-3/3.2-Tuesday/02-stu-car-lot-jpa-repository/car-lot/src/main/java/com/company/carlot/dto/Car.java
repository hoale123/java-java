package com.company.carlot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity // Storing in the database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name= "car") // custom name
public class Car {
    @Id // mark this id as the primary key.
    @GeneratedValue(strategy = GenerationType.AUTO) // assign first item to 1 second to 2
    private Integer id;
    private String make;
    private String model;
    private String year;
    private String color;

    public Car(Integer id, String make, String model, String year, String color) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Car(String make, String model, String year, String color) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(make, car.make) && Objects.equals(model, car.model) && Objects.equals(year, car.year) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, year, color);
    }
    //    The system must also allow callers to find cars by make, to find cars by color, and to find cars by make and color.

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
