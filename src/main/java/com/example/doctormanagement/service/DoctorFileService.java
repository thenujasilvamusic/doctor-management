package com.example.doctormanagement.service;

import com.example.doctormanagement.model.Doctor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorFileService {

    private static final String FILE_PATH = "doctors.txt";


    public List<Doctor> readDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return doctors;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String specialization = parts[2];
                    String[] timeSlotsArray = parts[3].split(";");
                    List<String> timeSlots = new ArrayList<>();
                    for (String slot : timeSlotsArray) {
                        timeSlots.add(slot);
                    }
                    doctors.add(new Doctor(id, name, specialization, timeSlots));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }


    public void writeDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String generateId() {
        return UUID.randomUUID().toString();
    }
}