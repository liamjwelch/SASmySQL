<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Student</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SAS - Student Administration System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Student</h3>


		<!-- 		//action:send over to Spring MVC mapping// the model will bind the data to the 'customer' attribute that is in the model // via post  -->
		<!-- 		here is where the model attribute is shown -->
		<form:form action="save" modelAttribute="student" method="POST">


			<!-- 		need to assosciate this data with a customerID -->
			<!-- without this line you'd lose the ID of the customer -->
			<form:hidden path="studentID" />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /><br>
						<form:errors path="firstName" cssClass="error" id="error" /></td>

					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /><br>
						<form:errors path="lastName" cssClass="error" id="error" /></td>
					</tr>

					<tr>
						<td><label>Address</label></td>
						<td><form:input path="address" /><br>
						<form:errors path="address" cssClass="error" id="error" /></td>
					</tr>

					<tr>
						<td><label>City</label></td>
						<td><form:input path="city" /><br>
						<form:errors path="city" cssClass="error" id="error" /></td>
					</tr>

					<tr>
						<td><label>Country</label></td>
						<td><form:input path="country" /><br>
						<form:errors path="country" cssClass="error" id="error" /></td>
					</tr>

					<tr>
						<td><label>Phone Number</label></td>
						<td><form:input path="phoneNumber" /><br>
						<form:errors path="phoneNumber" cssClass="error" id="error" /></td>
					</tr>

					<tr>
						<td><label>Major</label></td>
						<td><form:input path="major" /><br>
						<form:errors path="major" cssClass="error" id="error" /></td>
					</tr>


					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/student/list">Back to
				List</a>
		</p>

	</div>

</body>

</html>










