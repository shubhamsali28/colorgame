<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
<div id="header">
<h2>Loan Buyers</h2>
</div>
</div>

<!-- Table for customers -->
<div id="container">
<div id="content">


<table>
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Loan Amount</th>
<th>Email Address</th>
<th>Action</th>
</tr>

<!-- looping over the customer list -->
<c:forEach var="tempCustomers" items="${customers}">

<!-- looping for update links -->
<c:url var="tempUpdate" value="/customer/showFormToUpdate">
<c:param name="customerId" value="${tempCustomers.id}"></c:param>
</c:url>

<!-- looping for delete links -->
<c:url var="tempDelete" value="/customer/delete">
<c:param name="customerId" value="${tempCustomers.id}"></c:param>
</c:url>

<tr>
<td>${tempCustomers.firstName}</td>
<td>${tempCustomers.lastName}</td>
<td>${tempCustomers.amount}</td>
<td>${tempCustomers.email}</td>
<td>
<a href="${tempUpdate}">Update</a>

|

<a href="${tempDelete}" onclick="if(!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
</td>
</tr>
</c:forEach>
</table>

<br><br>
<!-- Add Customers button -->
<input type="button" value="Add Customer"
onclick="window.location.href='showFormToAdd'; return false;"
class="add-button"
/>

</div>
</div>


</body>
</html>