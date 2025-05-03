<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Doctor List</h2>
    <c:if test="${not empty doctors}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Specialization</th>
                <th>Time Slots</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="doctor" items="${doctors}">
                <tr>
                    <td>${doctor.name}</td>
                    <td>${doctor.specialization}</td>
                    <td>${doctor.timeSlots}</td>
                    <td>
                        <a href="/doctors/dashboard/${doctor.id}" class="btn btn-info btn-sm">View Dashboard</a>
                        <a href="/doctors/delete/${doctor.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete ${doctor.name}?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty doctors}">
        <p>No doctors found.</p>
    </c:if>
    <a href="/doctors/register" class="btn btn-primary">Add New Doctor</a>
</div>
</body>
</html>