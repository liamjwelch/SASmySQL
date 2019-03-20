<%-- 
    Document   : mainMenu
    Created on : 29-Jul-2018, 6:34:52 PM
    Author     : liamj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Home</title>
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

</head>

<div class="jumbotron border">

	<!--beginning of navbar-->
	<h1 class="h6">
		<div class="container">

			<nav
				class="navbar border navbar-expand-lg navbar-light bg-light justify-content-between">
				<div>
					<a class="navbar-brand"><h3>Student Administration System</h3></a>
					<ul class="navbar-nav">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Student </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/SASmysql/student/list"><strong>Student</strong></a>
							</div></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Teacher </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/SASmysql/teacher/list"><strong>Add</strong>
									a Teacher</a>
							</div></li>


						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> Courses </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/SASmysql/course/list"><strong>Add</strong>
									a Course</a>
							</div></li>

						<!--                                 <li class="nav-item dropdown"> -->
						<!--                                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> -->
						<!--                                         Enrollment -->
						<!--                                     </a> -->
						<!--                                     <div class="dropdown-menu" aria-labelledby="navbarDropdown"> -->
						<!--                                         <a class="dropdown-item" href="/fpTest_SAFE/teacher/addStudentToCourse"><strong>Add</strong> a Student to a Course</a>                                           -->
						<!--                                     </div> -->
						<!--                                 </li>                         -->


					</ul>
				</div>

			</nav>
		</div>
		<!--            end of navbar-->
	</h1>

	<p class="lead text-center">To access a field, please select an
		option from the appropriate dropdown menu.</p>

</div>
<!--         <div class="text-right"><a href="/fpTest_SAFE/logout">Logout</a></div> -->


</html>
