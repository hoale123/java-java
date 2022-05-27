package com.company.simplecrmapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity // Storing in the database
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//
@Table(name= "customer") // custom name, instantiate the name of the table we are using.
// default to className if no name.
public class Customer {
    public Customer(Integer id, String firstName, String lastName, String company, String phone, Set<Note> notes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
        this.notes = notes;
    }

    public Customer(String firstName, String lastName, String company, String phone, Set<Note> notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
        this.notes = notes;
    }

    public Customer() {
    }

    @Id // mark this id as the primary key. marks instant variable
    @GeneratedValue(strategy = GenerationType.AUTO) // assign first item to 1 second to 2
    private Integer id;
    private String firstName;
    private String lastName;

    private String company;
    private String phone;
    // must have customerId and refer to primary key.
    //cascade mean when deleted, delete all associate record in notes.
    //eager - query for customer, get all customer.
    //Lazy - just give me the customer.
    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes; // no duplicates.

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(company, customer.company) && Objects.equals(phone, customer.phone) && Objects.equals(notes, customer.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, company, phone, notes);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", notes=" + notes +
                '}';
    }
}
