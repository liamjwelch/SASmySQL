<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>List Results</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<%@include file="NavBar.jsp"%>


	<div id="container">

		<div id="content">



			<br>

			<!--  add our html table here -->

			<table class="table table-striped">
				<tr>
					<th>Mark</th>
				    <th>Student ID</th>
					<th>Course ID</th>
					<th>Action</th>
					
				</tr>

				<!-- loop over and print our results -->
				<c:forEach var="tempResult" items="${results}">

					<!--  construct an update "link" with Result ID -->
					<c:url var="updateLink" value="/result/showFormForUpdate">
						<c:param name="resultID" value="${tempResult.resultID }" />
					</c:url>

					<!--  construct an "delete" link with Result ID -->
					<c:url var="deleteLink" value="/result/delete">
						<c:param name="resultID" value="${tempResult.resultID }" />
					</c:url>

					<tr>
						<td>${tempResult.mark}</td>
						<td>${tempResult.student.studentID}</td>
						<td>${tempResult.course.courseID}</td>

						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							: <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this result?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

			<input type="button" value="Add Result"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn" />

		</div>

	</div>