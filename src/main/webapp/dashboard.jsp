<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>
    <!-- Bootstrap CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilo personalizado -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
         <h2>Dashboard</h2>
        <div class="welcome">Welcome, <%= request.getSession().getAttribute("user") %></div>
        <a href="LogoutServlet">Logout</a>
    </div>
    <!-- Bootstrap JS y Popper.js -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>