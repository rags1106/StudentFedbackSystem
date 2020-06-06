<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--
Template Name: Academic Education V2
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<html>
<head>
<title>Academic Education V2</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
 
 		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
     	 <link rel="stylesheet" href="css/style.css">
		<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        
     <style> 
     
     #form1{
     background-color:  #06213F;
     }
/* table ,thead,tbody,th,tr,td {
    border: 1px solid black;
     margin-left: -90px; 
    margin-top: 20px;
    width: 550px;
    height: 100px;
    margin-right: 50px;
} */
ul li{
font-size:15px;
}
</style>        
</head>
<body id="top">

<!-- ################################################################################################ -->
<div class="wrapper row0">
  <div id="topbar" class="clear"> 
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <div class="rounded">
    <nav id="mainav" class="clear"> 
      <!-- ################################################################################################ -->
      <ul class="clear">
     
        <li class="active"><a href="home.jsp">Home</a></li>
         <li><a href="stafftoStudent.jsp">Back</a></li>
       <!--  <li><a href="login.jsp">Admin Login</a></li>
        <li><a href="login.jsp">Staff Login</a></li>
        <li><a href="login.jsp">Student Login</a></li> -->
        <li><a href="LogoutServlet">Log out</a></li>
      </ul>
      <!-- ################################################################################################ --> 
    </nav>
  </div>
</div>
<!-- ################################################################################################ -->    

    
<div class="container">
<div class="row">
<div class="col-md-10">
  <form id="form1" action="staff_ViewStudent" method ="get" style="margin:0px;">
<table class="table table-striped" style="margin-left: 180px; width: 900px;"> 
  <thead>
    <tr>
     <!--  <th>#</th> -->
      <th >Student Id</th>		
	  <th >Student Name</th>
	  <th >Department</th>
	<th >Year</th>
	<th >Mobile</th>
	<th >Address</th>
	<th >Display Marks OF Student</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${DisplayRecord}" var="user">
    <tr>
      <!-- <th scope="row">1</th> -->
      <td ><c:out value="${user.id}" /></td>
	   <td><c:out value="${user.name}" /></td>
		<td><c:out value="${user.department}" /></td>
		<td><c:out value="${user.year}" /></td>
		<td><c:out value="${user.mobile}" /></td>
		<td><c:out value="${user.address}" /></td>
		<td><a href="CalculateServlet?action=getSubjectMarks&id=${user.id}">All Subject Marks</a></td>
    </tr>
    	</c:forEach>
  </tbody>
</table>
</form>
</div>
</div>
</div>		
				<%-- <table align="center" >
				
						<tr>
							<th class="thsvt">Student Id</th>		
							<th class="thsvt">Student Name</th>
							<th class="thsvt">Department</th>
							<th class="thsvt">Year</th>
							<th class="thsvt">Mobile</th>
							<th class="thsvt">Address</th>
							<th class="thsvt">Display Marks OF Student</th>
						</tr>
			
				        <c:forEach items="${DisplayRecord}" var="user">
							<tr>
							<td class="tdsvt"><c:out value="${user.id}" /></td>
							<td class="tdsvt"><c:out value="${user.name}" /></td>
							<td class="tdsvt"><c:out value="${user.department}" /></td>
							<td class="tdsvt"><c:out value="${user.year}" /></td>
							<td class="tdsvt"><c:out value="${user.mobile}" /></td>
							<td class="tdsvt"><c:out value="${user.address}" /></td>
							<!-- <td class="tdsvt"><a href="CalculateMarks.jsp">All Subject Marks</a></td> -->
							<td><a href="CalculateServlet?action=getSubjectMarks&id=${user.id}">All Subject Marks</a></td></tr>
						</c:forEach>
				        
			</table>
			 --%>

      
   <!-- JAVASCRIPTS --> 
<script src="layout/scripts/jquery.min.js"></script> 
<script src="layout/scripts/jquery.fitvids.min.js"></script> 
<script src="layout/scripts/jquery.mobilemenu.js"></script> 
<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
</body>
</html>