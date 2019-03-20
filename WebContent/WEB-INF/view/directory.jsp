<%-- 
    Document   : student_add
    Created on : Jun 16, 2018, 10:32:48 AM
    Author     : armando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script  src='view/script.js'></script>

        <title>${requestScope.title}  ${requestScope.action} </title>
    </head>


    <body onload="disableStudent(false)">


        <%@include file="NavBar.jsp" %>

        <div class="container">

            <div class="jumbotron jumbotron-fluid justify-content-center" >

                <div>
                    <h2 align="center">${requestScope.title}</h2>                               
                </div>

                ${requestScope.action}


                <form method="POST" action="/CGS/student_add">


<%--                     <%@include file="student.jsp" %> --%>
                    
                    <div class="form-row" >                     
                        
                        <div class="form-group col-md-1"></div>

                        <div class="form-group col-md-1">
                            <input type="submit" class="btn btn-primary" value="Save"></input>
                        </div>

                    </div>

                </form>            

            </div>

        </div>



        

    </body>
</html>
