<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Course</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>SAS - Student Administration System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Course</h3>
	
	
<!-- 		//action:send over to Spring MVC mapping// the model will bind the data to the 'customer' attribute that is in the model // via post  -->
<!-- 		here is where the model attribute is shown -->
		<form:form action="save" modelAttribute="course" method="POST">
		
		
<!-- 		need to assosciate this data with a customerID -->
<!-- without this line you'd lose the ID of the customer -->
		<form:hidden path="courseID"/>

			<table>
				<tbody>
					<tr>
						<td><label>Course Name:</label></td>
						<td><form:input path="courseName"/><br>
						<form:errors path="courseName" cssClass="error" id="error" /></td>
					</tr>
				
					<tr>
						<td><label>Credit:</label></td>
						<td><form:input path="credit"/><br>
						<form:errors path="credit" cssClass="error"/></td>
						
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/course/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










