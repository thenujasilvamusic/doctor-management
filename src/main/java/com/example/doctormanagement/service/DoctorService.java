package com.example.doctormanagement.service;

import com.example.doctormanagement.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorFileService fileService;


    public Doctor registerDoctor(String name, String specialization, List<String> timeSlots) {
        List<Doctor> doctors = fileService.readDoctors();
        String id = fileService.generateId();
        Doctor doctor = new Doctor(id, name, specialization, timeSlots);
        doctors.add(doctor);
        fileService.writeDoctors(doctors);
        return doctor;
    }


    public List<Doctor> getAllDoctors() {
        return fileService.readDoctors();
    }


    public Doctor findDoctorById(String id) {
        return fileService.readDoctors().stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public void updateDoctor(String id, String name, String specialization, List<String> timeSlots) {
        List<Doctor> doctors = fileService.readDoctors();
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                doctor.setName(name);
                doctor.setSpecialization(specialization);
                doctor.setTimeSlots(timeSlots);
                break;
            }
        }
        fileService.writeDoctors(doctors);
    }


    public void deleteDoctor(String id) {
        List<Doctor> doctors = fileService.readDoctors();
        doctors.removeIf(doctor -> doctor.getId().equals(id));
        fileService.writeDoctors(doctors);
    }
}