package com.example.doctormanagement.service;

import com.example.doctormanagement.model.Doctor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorFileService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorFileService.class);

    @Value("${doctors.file.path:doctors.txt}")
    private String filePath;

    public List<Doctor> readDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            return doctors;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length == 4) {
                    try {
                        Long id = Long.parseLong(parts[0].trim());
                        String name = parts[1] != null ? parts[1].trim() : "";
                        String specialization = parts[2] != null ? parts[2].trim() : "";
                        String timeSlots = parts[3] != null ? parts[3].trim() : "";
                        doctors.add(new Doctor(id, name, specialization, timeSlots));
                    } catch (NumberFormatException e) {
                        logger.error("Invalid ID format in line: {}", line, e);
                    }
                } else {
                    logger.warn("Invalid line format: {}", line);
                }
            }
        } catch (IOException e) {
            logger.error("Error reading doctors file: {}", filePath, e);
        }
        return doctors;
    }

    public void writeDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Doctor doctor : doctors) {
                String name = doctor.getName() != null ? doctor.getName().replace(",", "\\,") : "";
                String specialization = doctor.getSpecialization() != null ? doctor.getSpecialization().replace(",", "\\,") : "";
                String timeSlots = doctor.getTimeSlots() != null ? doctor.getTimeSlots().replace(",", "\\,") : "";
                String line = String.format("%d,%s,%s,%s", doctor.getId(), name, specialization, timeSlots);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.error("Error writing doctors file: {}", filePath, e);
        }
    }

    public Long generateId() {
        List<Doctor> existingDoctors = readDoctors();
        long newId = System.currentTimeMillis();
        
        while (true) {
            final long currentId = newId; 
            if (existingDoctors.stream().noneMatch(d -> d.getId().equals(currentId))) {
                return currentId;
            }
            newId++; 
        }
    }
}
