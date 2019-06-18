<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add Employee Data</h2>

	<div class="container">



		<form:form method="POST" action="http://localhost:8080/NewTest/save"
			modelAttribute="employee">
			<table>
				<tr>
					<td><form:label path="empId">Employee ID:</form:label></td>
					<td><form:input path="empId" value="${employee.empId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="empName">Employee Name:</form:label></td>
					<td><form:input path="empName" value="${employee.empName}" /></td>
				</tr>
				<tr>
					<td><form:label path="empAge">Employee Age:</form:label></td>
					<td><form:input path="empAge" value="${employee.empAge}" /></td>
				</tr>
				<tr>
					<td><form:label path="empSalary">Employee Salary:</form:label></td>
					<td><form:input path="empSalary" value="${employee.empSalary}" /></td>
				</tr>

				<tr>
					<td><form:label path="empAddress">Employee Address:</form:label></td>
					<td><form:input path="empAddress"
							value="${employee.empAddress}" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>


		<c:if test="${!empty employees}">
			<h2>List Employees</h2>
			<table align="left" border="1">
				<tr>
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Employee Age</th>
					<th>Employee Salary</th>
					<th>Employee Address</th>
					<th>Actions on Row</th>
				</tr>

				<c:forEach items="${employees}" var="employee">
					<tr>
						<td><c:out value="${employee.empId}" /></td>
						<td><c:out value="${employee.empName}" /></td>
						<td><c:out value="${employee.empAge}" /></td>
						<td><c:out value="${employee.empSalary}" /></td>
						<td><c:out value="${employee.empAddress}" /></td>
						<td align="center"><a href="edit/${employee.empId}">Edit</a>
							| <a href="delete/${employee.empId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


	</div>


</body>
</html>