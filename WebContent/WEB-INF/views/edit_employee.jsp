<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<li><a href="getEmployees">Show Employees</a></li>
		<li><a href="addEmployee">Add Employee</a></li>
		<li><a class="active" href="#">Edit Employee</a>
	</ul>
	<h1>Edit an Employee Page</h1>
	<div align="center">
		<form:form action="updateEmployee" method="post" 
			modelAttribute="editedemployee">
			<table>
				<form:hidden path="id" />
				
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" /></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Email</td>
					<td><form:input path="email" /></td>
				</tr>

				<form:hidden path="department.id"/>

				<tr>
					<td>Department Name</td>
					<td><form:input path="department.name" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Update Employee"></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>