package com.example.doctormanagement.controller;

import com.example.doctormanagement.model.Doctor;
import com.example.doctormanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/list")
    public String showDoctorList(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "register";
    }

    @PostMapping("/register")
    public String registerDoctor(@ModelAttribute("doctor") Doctor doctor,
                                 @RequestParam("timeSlots") String timeSlotsStr) {
        List<String> timeSlots = Arrays.asList(timeSlotsStr.split(";"));
        doctorService.registerDoctor(doctor.getName(), doctor.getSpecialization(), timeSlots);
        return "redirect:/doctors/list";
    }

    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable("id") Long id, Model model) {
        Doctor doctor = doctorService.findDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "dashboard";
    }

    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors/list";
    }
}