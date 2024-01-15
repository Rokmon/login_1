<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
    <!-- Bootstrap CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Estilo personalizado -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
       <h2>Login</h2>
        <% String error = request.getParameter("error"); %>
        <% if (error != null) { %>
            <div class="error">Invalid username or password.</div>
        <% } %>
        <form action="LoginServlet" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            <input type="submit" value="Login">
        </form>
    </div>
    <!-- Bootstrap JS y Popper.js (opcional, necesario para componentes Bootstrap que requieren JavaScript como modales o tooltips) -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>