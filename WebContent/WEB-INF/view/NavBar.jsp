<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="cgs.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<!--beginning of navbar-->
	<h1 class="h6">

		<nav
			class="navbar border navbar-expand-lg navbar-light bg-light justify-content-between">
			<div>
				<a class="navbar-brand"><h3>Student Administration System</h3></a>
				<ul class="navbar-nav">

					<li class="nav-item"><a class="dropdown-item"
						href="/SASmysql/student/list">Student</a></li>

					<li class="nav-item"><a class="dropdown-item"
						href="/SASmysql/teacher/list">Teacher</a></li>


					<li class="nav-item"><a class="dropdown-item"
						href="/SASmysql/course/list">Course</a></li>

				</ul>

			</div>

			<form:form class="form-inline md-form form-sm" action="search"
				method="POST">
				<div class="input-group mb-3">
					<div class="input-group-prepend">
						<button class="btn btn-outline-secondary" type="submit"
							value="Search" class="btn">Search</button>
					</div>
					<input type="text" class="form-control" placeholder=""
						aria-label="" name="theSearchName" aria-describedby="basic-addon1">
				</div>
			</form:form>



		</nav>
		<!--            end of navbar-->
	</h1>

</body>
</html>