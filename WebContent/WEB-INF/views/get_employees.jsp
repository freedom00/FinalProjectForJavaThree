<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Final Project Three</title>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
</head>
<body>
	<ul>
		<li><a href="../index.jsp">Home</a></li>
		<li><a class="active" href="#">Show Employees</a></li>
		<li><a href="addEmployee">Add Employee</a></li>
	</ul>
	<h1>Show Employees Page</h1>
	<div align="center">
		<h1>Employees</h1>
		<table border="1">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			<c:forEach var="employee" items="${employees}">
				<tr>
					<td><c:out value="${employee.firstName}"></c:out></td>
					<td><c:out value="${employee.lastName}"></c:out></td>
					<td><c:out value="${employee.email}"></c:out></td>
					<td><a href="editEmployee?employeeId=${employee.id}">edit</a></td>
					<td><a href="deleteEmployee?employeeId=${employee.id}">delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>