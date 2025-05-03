package com.example.doctormanagement.model;

public class Doctor {
    private Long id;
    private String name;
    private String specialization;
    private String timeSlots;

    
    public Doctor() {}

    
    public Doctor(Long id, String name, String specialization, String timeSlots) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.timeSlots = timeSlots;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; } 
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getTimeSlots() { return timeSlots; }
    public void setTimeSlots(String timeSlots) { this.timeSlots = timeSlots; }

    @Override
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "', specialization='" + specialization + "', timeSlots='" + timeSlots + "'}";
    }
}
