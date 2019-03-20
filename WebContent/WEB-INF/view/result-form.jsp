<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="com.sas.entity.Result"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Result</title>

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
		<h3>Save Result</h3>


		<!-- 		//action:send over to Spring MVC mapping// the model will bind the data to the 'customer' attribute that is in the model // via post  -->
		<!-- 		here is where the model attribute is shown -->
		<form:form action="save" modelAttribute="result" method="POST">


			<!-- 		need to assosciate this data with a customerID -->
			<!-- without this line you'd lose the ID of the customer -->
			<form:hidden path="resultID" />

			<table>
				<tbody>
					<tr>
						<td><form:label path='student.studentID'>
								<spring:message text='Students:	' />
							</form:label></td>
						<td><form:select path="student.studentID"
								class="form-control">
								<form:options items="${studentList}" itemLabel="firstName"
									itemValue="studentID" />
							</form:select></td>
					</tr>

					<tr>
						<!-- 						space for dropdown -->

						<td><form:label path='course.courseID'>
								<spring:message text='Courses:	' />
							</form:label></td>
						<td><form:select path="course.courseID" class="form-control">
								<form:options items="${courseList}" itemLabel="courseName"
									itemValue="courseID" />
							</form:select></td>

					</tr>



					<tr>
						<td><label>Mark</label></td>
						<td><form:input path="mark" /><br>
						<form:errors path="mark" cssClass="error" id="error" /></td>
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
			<a href="${pageContext.request.contextPath}/result/list">Back to
				List</a>
		</p>

	</div>

</body>

</html>










