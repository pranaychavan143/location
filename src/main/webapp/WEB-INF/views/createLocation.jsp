<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form action="savelocation" method="post">
Id <input type="text" name="id"/><br>
Code <input type="text" name="code"/><br>
Name <input type="text" name="name"/><br>
Type: Urban <input type="radio"name="type" value="URBAN"/>
		   Rural<input type="radio" name="type"value="RURAL"/><br>
		   
		   <input type="submit"value="save"/>
</form>
${msg }

<a href="displayLocation">View All</a>
</body>
</html>