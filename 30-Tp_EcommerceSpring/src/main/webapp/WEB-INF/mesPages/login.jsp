<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="<c:url value="/resources/js/bootstrap.js"/>" />
<link href="<c:url value="/resources/css/bootstrap.css"/>" />
</head>
<body>

<div class="container">
  <h2>Login</h2>
  <form method="post" action="j_spring_security_check">
    <div class="form-group">
      <label for="id">Identifiant:</label>
      <input type="text" name="j_username" class="form-control" id="id" placeholder="Enter identifiant">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" name="j_password" class="form-control" id="pwd" placeholder="Enter password">
    </div>
  
    <button type="submit" class="btn btn-default">Se connecter</button>
  </form>
</div>
</body>
</html>