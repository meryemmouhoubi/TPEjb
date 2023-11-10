<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <style>
        body {
            background-color: #000; /* Black background color */
            color: #fff; /* White text color */
            height: 100vh; /* Full height of the viewport */
            margin: 0; /* Remove default margin */
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .custom-container {
            text-align: center;
        }

        .custom-button {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            background-color: #e83e8c !important; /* Use !important to override Bootstrap styles */
            color: #fff;
            font-size: 16px;
            margin: 10px;
            border: none;
        }
    </style>
</head>
<body>
    <div class="container custom-container">
        <form action="EtudiantController" style="display: inline-block;">
            <button class="btn btn-primary custom-button">Les Etudiants</button>
        </form>
        
        <form action="FiliereController" style="display: inline-block;">
            <button class="btn btn-primary custom-button">Filieres</button>
        </form>
        
        <form action="RoleController" style="display: inline-block;">
            <button class="btn btn-primary custom-button">Roles</button>
        </form>
    </div>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
