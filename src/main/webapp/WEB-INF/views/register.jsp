<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Registration</title>
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
    </style>
</head>
<body>
<div class="header">
    <img src="/resources/images/logo.png" alt="Hospital Logo" class="logo">
</div>
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
            <label for="timeSlots" class="form-label">Available Time Slots (semicolon-separated, e.g., 10:00-11:00;11:00-12:00)</label>
            <input type="text" class="form-control" id="timeSlots" name="timeSlots" required>
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
        <a href="/doctors/list" class="btn btn-secondary">View All Doctors</a>
    </form>
</div>
</body>
</html>