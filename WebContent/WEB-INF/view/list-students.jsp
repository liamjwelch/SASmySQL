<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>List Students</title>

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
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th>City</th>
					<th>Country</th>
					<th>Phone Number</th>
					<th>Major</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempStudent" items="${students}">

					<!--  construct an update "link" with Student ID -->
					<c:url var="updateLink" value="/student/showFormForUpdate">
						<c:param name="studentID" value="${tempStudent.studentID }" />
					</c:url>

					<!--  construct an "delete" link with Student ID -->
					<c:url var="deleteLink" value="/student/delete">
						<c:param name="studentID" value="${tempStudent.studentID }" />
					</c:url>

					<tr>
						<td>${tempStudent.firstName}</td>
						<td>${tempStudent.lastName}</td>
						<td>${tempStudent.address}</td>
						<td>${tempStudent.city}</td>
						<td>${tempStudent.country}</td>
						<td>${tempStudent.phoneNumber}</td>
						<td>${tempStudent.major}</td>
						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							: <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

			<input type="button" value="Add Student"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn" />

		</div>

	</div>

	<!-- <!-- Button trigger modal -->
	
	<!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> -->
	<!--   Launch demo modal -->
	<!-- </button> -->

	<!-- <!-- Modal -->
	
	<!-- <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true"> -->
	<!--   <div class="modal-dialog" role="document"> -->
	<!--     <div class="modal-content"> -->
	<!--       <div class="modal-header"> -->
	<!--         <h5 class="modal-title" id="exampleModalLabel">Modal title</h5> -->
	<!--         <button type="button" class="close" data-dismiss="modal" aria-label="Close"> -->
	<!--           <span aria-hidden="true">&times;</span> -->
	<!--         </button> -->
	<!--       </div> -->
	<!--       <div class="modal-body"> -->

	<%--        <%@include file=""%> --%>

	<!--       </div> -->
	<!--       <div class="modal-footer"> -->
	<!--         <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
	<!--         <button type="button" class="btn btn-primary">Save changes</button> -->
	<!--       </div> -->
	<!--     </div> -->
	<!--   </div> -->
	<!-- </div> -->

	<!-- </body> -->

	<!-- </html> -->