# Doctor Management System
## Overview
A web-based application to manage doctor registration, specialization, and time slots using Spring Boot and JSP.

## Features
- Register a new doctor (Create)
- View all doctors (Read)
- Update doctor details (Update)
- Delete a doctor (Delete)
- Doctor dashboard to view profile

## OOP Concepts Used
- **Encapsulation**: Doctor class with private fields and getters/setters.
- **Inheritance**: Can be extended for future classes like SpecialistDoctor.
- **Polymorphism**: Can be implemented for different doctor types in future iterations.

## File Handling
- Data is stored in `doctors.txt` using file read/write operations.

## How to Run
1. Clone the repository.
2. Open in IntelliJ IDEA.
3. Run `DoctorManagementApplication.java`.
4. Access at `http://localhost:8080/doctors/register`.
