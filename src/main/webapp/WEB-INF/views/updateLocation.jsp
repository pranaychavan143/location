<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form action="updateLocation" method="post">
Id <input type="text" name="id" value="${location.id }" readonly/><br>
Code <input type="text" name="code" value="${location.code }"/><br>
Name <input type="text" name="name" value="${location.name }" /><br>
Type: Urban <input type="radio"name="type" value="URBAN" value=${location.type=='URBAN'?'checked':' '} />
		   Rural<input type="radio" name="type"value="RURAL" value=${location.type=='RURAL'?'checked':' '}/><br>
		   
		   <input type="submit"value="save"/>
</form>
</body>
</html>