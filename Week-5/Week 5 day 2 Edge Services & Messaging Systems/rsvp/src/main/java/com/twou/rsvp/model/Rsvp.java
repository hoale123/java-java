package com.twou.rsvp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
@Entity
@JsonIgnoreProperties({"jsonLazyInitializer", "handler"})
@Table(name = "rsvp")
public class Rsvp implements Serializable {
    private Long id;
    private String guestName;
    private int totalAttending;

    public Rsvp() {

    }

    public Rsvp(String guestName, int totalAttending) {
        this.guestName = guestName;
        this.totalAttending = totalAttending;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getTotalAttending() {
        return totalAttending;
    }

    public void setTotalAttending(int totalAttending) {
        this.totalAttending = totalAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rsvp rsvp = (Rsvp) o;
        return totalAttending == rsvp.totalAttending && Objects.equals(id, rsvp.id) && Objects.equals(guestName, rsvp.guestName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guestName, totalAttending);
    }

    @Override
    public String toString() {
        return "Rsvp{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", totalAttending=" + totalAttending +
                '}';
    }
}
