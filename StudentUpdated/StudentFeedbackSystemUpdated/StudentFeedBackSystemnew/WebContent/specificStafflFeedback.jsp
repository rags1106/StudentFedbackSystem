<!DOCTYPE html>
<!--
Template Name: Academic Education V2
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
 <script type="text/javascript">
   function preventBack()
   {
	   //alert("hiiiiiiiiiiiiii");
	   window.history.forward();
   }
   setTimeout("preventBack()",0);
   window.onunload = function()
   {
	   null
   };
   </script>
   <script type="text/javascript">
   function displaymsg()
   {
	   var email=$('#mail').val();
	   var password=$('#name').val();
	   $.ajax({
		  url:'UserServlet',
		  method:'POST',
		  data:{action:"Login",email:email,password:password},
		  success:function(data)
		  {
	   
		  
			  alert("Invalid UserName and Password");
			  $('#mail').val("");
			  $('#name').val("");
			  return false;
		
			  
		  }
	   
		   
		   
		   
	   });
   }
   
   
   
   </script>
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
        <li class="active"><a href="stafftoStudent.jsp">Back</a></li>
         <li><a href="LogoutServlet">Log out</a></li>
       <!--  <li><a href="login.jsp">Admin Login</a></li>
        <li><a href="login.jsp">Staff Login</a></li>
        <li><a href="login.jsp">Student Login</a></li> -->
     <!--    <li><a href="#">Log out</a></li> -->
      </ul>
      <!-- ################################################################################################ --> 
    </nav>
  </div>
</div>
<!-- ################################################################################################ --> 
<br>
<br>

	<%-- <%
	String loginmsg=(String)request.getAttribute("error");
	if(loginmsg!=null)
	out.println("<font color=red size=4px>"+loginmsg+"</font>");		
	
	
	%> --%>

<div class="container">
<!-- <form action="UserServlet" method="POST">  -->
 <div class="row">
		                <div class="col-md-3"></div>
		                 <center><table border="1" class="table table-hover" style=";width:500px;height:40px;font-size:25px;background-color:black;" >

				<tr  style="height:40px;" >
					<!-- <th>FACULTY ID</th> -->
					<th>FEEDBACK STATUS</th>
					<th>FEEDBACK COUNT</th>
					<!-- <th>FACULTY ADDRESS</th>
					<th>CONTACT NO</th> -->
				
					<tbody>
				<c:forEach items="${getList1}" var="user" varStatus="count">
				<tr class="editField">
					<td >${user.feedback_status}</td>
					<td>${user.feedback_total}</td>
					<%-- <td><a href="UserServlet?action=seefeedback&faculty_id=${user.faculty_id}">View Feedback</a></td> --%>
					
				</tr>
				</c:forEach>
			</table>
			</center>
				       </div> 
				       
				      
				       
				      
    <!--   <form action="UserServlet" method="post" style="text-decoration: ">    -->
             <%--  <label for="name">Select Faculty:</label>
             <c:forEach items="${userlist}" var="user" varStatus="count">
             <select style="width:400px;" name="department" required="">
        	 <option value="${user.faculty_id}">${user.faculty_name}</option>
        	</c:forEach>
        	</select>   --%>
	        <%-- <center><table border="1" class="table table-hover" style=";width:1500px;height:40px;font-size:30px;background-color:black;" >

				<tr  style="height:40px;" >
					<!-- <th>FACULTY ID</th> -->
					<th>FACULTY NAME</th>
					<th>ACTION</th>
					<!-- <th>FACULTY ADDRESS</th>
					<th>CONTACT NO</th> -->
				
					<tbody>
				<c:forEach items="${userlist}" var="user" varStatus="count">
				<tr class="editField">
					<td style="display:none;">${user.faculty_id}</td>
					<td>${user.faculty_name}</td>
					<td><a href="UserServlet">Send Feedback</a></td>
					<td>${user.address}</td>
					<td>${user.mobile}</td> 
				</tr>
				</c:forEach>
			</table>
			</center> --%>
			<!-- </form>   -->
	 </div>               
         
    <!--    </form> 
  -->
   <!-- JAVASCRIPTS --> 
<script src="layout/scripts/jquery.min.js"></script> 
<script src="layout/scripts/jquery.fitvids.min.js"></script> 
<script src="layout/scripts/jquery.mobilemenu.js"></script> 
<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
</body>
</html>