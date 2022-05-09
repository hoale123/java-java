package com.TelevisionShows.tvshows;

import java.util.Objects;

public class TvShows {
    private String name;
    private int year;
    private double avgReviews;
    private String service;
    private int id;
    private static int serialNumber = 1;

    public TvShows(String name, int year, double avgReviews, String service) {
        this.name = name;
        this.year = year;
        this.avgReviews = avgReviews;
        this.service = service;
        this.id = serialNumber;
        serialNumber++;
    }

    public TvShows() {
        this.id = serialNumber;
        serialNumber++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAvgReviews() {
        return avgReviews;
    }

    public void setAvgReviews(double avgReviews) {
        this.avgReviews = avgReviews;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    //compare object shadowing. references
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShows tvShows = (TvShows) o;
        return year == tvShows.year && Double.compare(tvShows.avgReviews, avgReviews) == 0 && id == tvShows.id && Objects.equals(name, tvShows.name) && Objects.equals(service, tvShows.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, avgReviews, service, id);
    }

    @Override
    public String toString() {
        return "TvShows{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", avgReviews=" + avgReviews +
                ", service='" + service + '\'' +
                ", id=" + id +
                '}';
    }
}
