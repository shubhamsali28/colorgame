<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>


<div id="wrapper">
<div id="header">
<h2>Add New Customer</h2>
</div>
</div>

<div id="container">

<form:form action="saveCustomer" method="POST" modelAttribute="customer">

<!-- Very important for updating the selected customer -->
<form:hidden path="id"/>

<table>
<tbody>

<tr>
<td><label>First Name</label></td>
<td><form:input path="firstName"/></td>
</tr>

<tr>
<td><label>Last Name</label></td>
<td><form:input path="lastName"/></td>
</tr>

<tr>
<td><label>Loan Amount</label></td>
<td><form:input path="amount"/></td>
</tr>

<tr>
<td><label>Email Address</label></td>
<td><form:input path="email"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Save" class="save"/></td>
</tr>

</tbody>
</table>

</form:form>

<div style="clear; both;"></div>

<p>
<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</p>
</div>


</body>
</html>