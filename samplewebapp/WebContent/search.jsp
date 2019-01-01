<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product search</title>
</head>
<body>
<h2 align=center>Search for product</h2>
<div align=center>
<form action="ProductSearch" >
Product ID: <input type="text" name=pid>
<input type="submit" value="search">
</form>
</div>

<c:if test="${not empty product}">

<h2 align=center>Searched product</h2>
<table align=center border=2>
<tr><th>ProductId</th><th>Name</th><th>Price</th><th>Quantity</th><th>Description</th></tr>
<tr><td>${product.id}</td><td>${product.name}</td><td>${product.price}</td><td>${product.quantity}</td><td>${product.description}</td></tr>
</table>
</c:if>
</body>
</html>