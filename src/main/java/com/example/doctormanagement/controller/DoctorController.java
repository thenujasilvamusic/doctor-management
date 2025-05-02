package com.example.doctormanagement.controller;

import com.example.doctormanagement.model.Doctor;
import com.example.doctormanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "register";
    }


    @PostMapping("/register")
    public String registerDoctor(
            @RequestParam String name,
            @RequestParam String specialization,
            @RequestParam String timeSlots,
            Model model) {
        List<String> slots = Arrays.asList(timeSlots.split(","));
        Doctor doctor = doctorService.registerDoctor(name, specialization, slots);
        model.addAttribute("doctorId", doctor.getId());
        return "redirect:/doctors/dashboard/" + doctor.getId();
    }


    @GetMapping("/list")
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "list";
    }


    @GetMapping("/dashboard/{id}")
    public String showDashboard(@PathVariable String id, Model model) {
        Doctor doctor = doctorService.findDoctorById(id);
        if (doctor == null) {
            return "redirect:/doctors/list";
        }
        model.addAttribute("doctor", doctor);
        return "dashboard";
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable String id, Model model) {
        Doctor doctor = doctorService.findDoctorById(id);
        if (doctor == null) {
            return "redirect:/doctors/list";
        }
        model.addAttribute("doctor", doctor);
        return "update";
    }


    @PostMapping("/update/{id}")
    public String updateDoctor(
            @PathVariable String id,
            @RequestParam String name,
            @RequestParam String specialization,
            @RequestParam String timeSlots,
            Model model) {
        List<String> slots = Arrays.asList(timeSlots.split(","));
        doctorService.updateDoctor(id, name, specialization, slots);
        return "redirect:/doctors/dashboard/" + id;
    }


    @GetMapping("/delete/{id}")
    public String deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors/list";
    }
}