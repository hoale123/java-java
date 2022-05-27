package com.company.CoffeeInventoryJpaRepositoryHoaLe.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer roasterId;

    private String name;
    private Integer count;
    private BigDecimal unitPrice;
    private String description;
    private String type;

    public Coffee(Integer roasterId, String name, Integer count, BigDecimal unitPrice, String description, String type) {
        this.roasterId = roasterId;
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
        this.description = description;
        this.type = type;
    }

    public Coffee(Integer id, Integer roasterId, String name, Integer count, BigDecimal unitPrice, String description, String type) {
        this.id = id;
        this.roasterId = roasterId;
        this.name = name;
        this.count = count;
        this.unitPrice = unitPrice;
        this.description = description;
        this.type = type;
    }

    public Coffee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(Integer roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) && Objects.equals(roasterId, coffee.roasterId) && Objects.equals(name, coffee.name) && Objects.equals(count, coffee.count) && Objects.equals(unitPrice, coffee.unitPrice) && Objects.equals(description, coffee.description) && Objects.equals(type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roasterId, name, count, unitPrice, description, type);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", roasterId=" + roasterId +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", unitPrice=" + unitPrice +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
