<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Doctor Dashboard</h2>
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