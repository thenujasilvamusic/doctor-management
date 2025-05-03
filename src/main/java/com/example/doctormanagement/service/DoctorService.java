package com.example.doctormanagement.service;

import com.example.doctormanagement.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorFileService fileService;

    public Doctor registerDoctor(String name, String specialization, List<String> timeSlots) {
        List<Doctor> doctors = fileService.readDoctors();
        Long id = fileService.generateId();
        String timeSlotsString = timeSlots != null ? String.join(";", timeSlots) : "";
        Doctor doctor = new Doctor(id, name, specialization, timeSlotsString);
        doctors.add(doctor);
        fileService.writeDoctors(doctors);
        return doctor;
    }

    public List<Doctor> getAllDoctors() {
        return fileService.readDoctors();
    }

    public Doctor findDoctorById(Long id) {
        return fileService.readDoctors().stream()
                .filter(doctor -> doctor.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updateDoctor(Long id, String name, String specialization, List<String> timeSlots) {
        List<Doctor> doctors = fileService.readDoctors();
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                doctor.setName(name);
                doctor.setSpecialization(specialization);
                doctor.setTimeSlots(timeSlots != null ? String.join(";", timeSlots) : "");
                break;
            }
        }
        fileService.writeDoctors(doctors);
    }

    public void deleteDoctor(Long id) {
        List<Doctor> doctors = fileService.readDoctors();
        doctors.removeIf(doctor -> doctor.getId().equals(id));
        fileService.writeDoctors(doctors);
    }
}