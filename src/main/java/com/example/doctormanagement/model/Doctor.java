package com.example.doctormanagement.model;

import java.io.Serializable;
import java.util.List;

public class Doctor implements Serializable {
    private String id;
    private String name;
    private String specialization;
    private List<String> timeSlots;


    public Doctor() {}


    public Doctor(String id, String name, String specialization, List<String> timeSlots) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.timeSlots = timeSlots;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<String> timeSlots) {
        this.timeSlots = timeSlots;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + specialization + "," + String.join(";", timeSlots);
    }
}