<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>List Courses</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SAS - Student Administration System<h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Course -->

			<input type="button" value="Add Course"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
				
            <!--  add a search box -->
            <form:form action="search" method="POST" width="min-content">
                Search courses: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>				


			<!--  add our html table here -->

			<table>
				<tr>
					<th>Course Name</th>
					<th>Credit</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="c" items="${courses}">

					<!--  construct an update "link" with Student ID -->
					<c:url var="updateLink" value="/course/showFormForUpdate">
						<c:param name="courseID" value="${c.courseID }" />
					</c:url>

					<!--  construct an "delete" link with Student ID -->
					<c:url var="deleteLink" value="/course/delete">
						<c:param name="courseID" value="${c.courseID }" />
					</c:url>


					<tr>
						<td>${c.courseName}</td>
						<td>${c.credit}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							: <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>









