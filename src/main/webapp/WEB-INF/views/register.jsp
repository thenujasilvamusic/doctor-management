<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Doctor Registration</h2>
    <form action="/doctors/register" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" required>
        </div>
        <div class="mb-3">
            <label for="specialization" class="form-label">Specialization</label>
            <input type="text" class="form-control" id="specialization" name="specialization" required>
        </div>
        <div class="mb-3">
            <label for="timeSlots" class="form-label">Available Time Slots (comma-separated, e.g., 9:00-10:00,10:00-11:00)</label>
            <input type="text" class="form-control" id="timeSlots" name="timeSlots" required>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
        <a href="/doctors/list" class="btn btn-secondary">View All Doctors</a>
    </form>
</div>
</body>
</html>