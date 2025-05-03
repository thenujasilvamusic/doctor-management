<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Dashboard</title>
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
        .dashboard-icon {
            max-width: 50px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="header">
    <img src="/resources/images/logo.png" alt="Hospital Logo" class="logo">
</div>
<div class="container mt-5">
    <h2>Doctor Dashboard</h2>
    <img src="/resources/images/dashboard-icon.png" alt="Dashboard Icon" class="dashboard-icon">
    <c:if test="${not empty doctor}">
        <p><strong>Name:</strong> ${doctor.name}</p>
        <p><strong>Specialization:</strong> ${doctor.specialization}</p>
        <p><strong>Time Slots:</strong> ${doctor.timeSlots}</p>
    </c:if>
    <c:if test="${empty doctor}">
        <p>Doctor not found.</p>
    </c:if>
    <a href="/doctors/list" class="btn btn-secondary">Back to List</a>
</div>
</body>
</html>