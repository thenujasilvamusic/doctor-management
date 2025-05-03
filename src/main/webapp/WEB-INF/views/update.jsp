<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Doctor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Update Doctor</h2>
    <form action="/doctors/update/${doctor.id}" method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${doctor.name}" required>
        </div>
        <div class="mb-3">
            <label for="specialization" class="form-label">Specialization</label>
            <input type="text" class="form-control" id="specialization" name="specialization" value="${doctor.specialization}" required>
        </div>
        <div class="mb-3">
            <label for="timeSlots" class="form-label">Available Time Slots (comma-separated)</label>
            <input type="text" class="form-control" id="timeSlots" name="timeSlots" value="${doctor.timeSlots}" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="/doctors/dashboard/${doctor.id}" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>