<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Responsive Login Form HTML CSS | CodingNepal</title>
  <link rel="stylesheet" href="css/login.css" />
  <!-- Font Awesome CDN link for icons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
</head>
<body>
  <div class="wrapper">
    <div class="title"><span>Login Form</span></div>
    <form action="authenticate" method="post" >
      <div class="row">
        <i class="fas fa-user"></i>
        <input type="text" name="username" placeholder="Email or Phone" required />
      </div>
      <div class="row">
        <i class="fas fa-lock"></i>
        <input type="password" name="password" placeholder="Password" required />
      </div>
     <!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />-->
      <div class="pass"><a href="#">Forgot password?</a></div>
      <div class="row button">
        <input type="submit" value="Login" />
      </div>
      <div class="signup-link">Not a member? <a href="/reg">Signup now</a></div>
    </form>
    <div><c:if test="${param.error}">
        <p style="color: red; text-align: center;">Invalid username or password.</p>
    </c:if>
    <c:if test="${param.logout}">
        <p style="color: green; text-align: center;">You have been logged out.</p>
    </c:if></div>
  </div>
</body>
</html>