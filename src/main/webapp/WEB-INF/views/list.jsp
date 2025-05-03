<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: url('/resources/images/background.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            min-height: 100vh;
        }
        .header {
            background-color: #ffffff;
            padding: 10px 0;
            text-align: center;
        }
        .logo {
            max-width: 300px;
            height: auto;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
        }
        .delete-btn {
            margin-left: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="/resources/images/logo.png" alt="Hospital Logo" class="logo">
</div>
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
                        <a href="/doctors/delete/${doctor.id}" class="btn btn-danger btn-sm delete-btn" onclick="return confirm('Are you sure you want to delete ${doctor.name}?')">
                            <img src="/resources/images/delete-icon.png" alt="Delete" style="max-width: 20px; vertical-align: middle;"> Delete
                        </a>
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