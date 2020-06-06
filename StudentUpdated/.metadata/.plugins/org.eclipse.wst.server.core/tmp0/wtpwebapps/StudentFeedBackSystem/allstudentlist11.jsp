<!DOCTYPE html>
<!--
Template Name: Academic Education V2
Author: <a href="http://www.os-templates.com/">OS Templates</a>
Author URI: http://www.os-templates.com/
Licence: Free to use under our free template licence terms
Licence URI: http://www.os-templates.com/template-terms
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css"> -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="css/style.css">
 		<link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css/main.css">
        <link href="layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
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
   <script type="text/javascript">

	function updateDetails(counter)
	{
  	 var student_id =$("#studentID"+counter).text();
  	 alert(student_id);
      	 $.ajax({
      		 type:"POST",
      		 url : "UserServlet",
      		 data : {student_id:student_id , action:"studentDetailsONID"},
      		 success : function(data)
      		{
      			 if(data!=0)
	 				 {
      				
      				 alert(data.student_name);
      				 $("#student_id").val(data.student_id);
   				 $("#student_name").val(data.student_name);
   				 $("#department").val(data.student_department);
   				 $("#year").val(data.year);
   				 $("#mobile").val(data.mobile);
   				 $("#address").val(data.address);
   				 $("#email").val(data.email); 
   				
   				
      				
   			  $("#myModal").modal("show");
	 				
	 			
	 				
	 				 }
	 			 else
	 				 {
	 			     alert("Sorry!!!!Details Not Available!!");
	 				 }
	 			
      		}
      	 });
      	 
      	 
       }

 
 	
	</script>     
	<script>
	
	function updateDetails1(){
		var student_id =$("#student_id").val();
	   	 alert(student_id);
	   	 
		 var student_name =$("#student_name").val();
	   	 alert(student_name);
	   	 
	   	var student_department =$("#student_department").val();
	   	 alert(student_department);
	   	 
	   	var year =$("#year").val();
	   	 alert(year);
	   	 
	   	var mobile =$("#mobile").val();
	   	 alert(mobile);
	   	 
	 	var address =$("#address").val();
	   	 alert(address);
	   	 
	 	var email =$("#email").val();
	   	 alert(email);
	   	 
	 	
	   	 
	   	 
	   	$.ajax({
	   	 type:"POST",
  		 url : "UserServlet",
     		 data : {student_id:student_id,student_name:student_name,student_department:student_department,year:year,mobile:mobile,address:address,email:email , action:"updateStudentDetails"},
     		 success : function(data)
     		{
     			 if(data==true)
	 				 {
     				
	 				
	 			alert("Details Updated Successfully!!");
	 				
	 				 }
	 			 else
	 				 {
	 			     alert("Sorry!!!!Details Not Updated!!");
	 				 }
	 			
     		}
     	 });
     	 
	}
	
	
	
	
	
	
	
	
	
	
	
	</script>
<title>Academic Education V2</title>
    


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
        <li class="active"><a href="adminAction.jsp">Back</a></li>
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
		            
		                  <center><table border="1" class="table " style=";width:500px;height:40px;font-size:25px;color:black;" >

				<tr  style="height:40px;" >
					<!-- <th>FACULTY ID</th> -->
					<th>FACULTY NAME</th>
					<th>UPDATE</th>
				    <th>DELETE</th>
					<!-- <th>CONTACT NO</th>  -->
				
					<tbody>
				<c:forEach items="${studentlist}" var="user" varStatus="count">
				<tr class="editField">
					<td id="studentID${count.index}" style="display:none;">${user.student_id}</td>
					<td>${user.student_name}</td>
					<td><a onclick="updateDetails(${count.index});" >Update</a></td>
					<td><a href="UserServlet?action=deleteStudent&student_id=${user.student_id}">Delete</a></td>
					<%-- <td id=""> <a onclick="updateDetails(${count.index});" style="color:white;"> UPDATE  </a>  </td> --%>
				</tr>
				</c:forEach>
			</table>
			</center>    
		                 <%-- <center><table border="1" class="table " style=";width:500px;height:40px;font-size:25px;color:black;" >

				<tr  style="height:40px;" >
					<!-- <th>FACULTY ID</th> -->
					<th>FACULTY NAME</th>
					<th>UPDATE</th>
				    <th>DELETE</th>
					<!-- <th>CONTACT NO</th>  -->
				
					<tbody>
				<c:forEach items="${studentlist}" var="user" varStatus="count">
				<tr class="editField">
					<td id="studentID${count.index}" style="display:none;">${user.student_id}</td>
					<td>${user.student_name}</td>
					<td><a onclick="updateDetails(${count.index});" >Update</a></td>
					<td><a href="UserServlet?action=deleteStudent&student_id=${user.student_id}">Delete</a></td>
					<td id=""> <a onclick="updateDetails(${count.index});" style="color:white;"> UPDATE  </a>  </td>
				</tr>
				</c:forEach>
				<tr>
				<td> supriya</td>
				<td><a href=""  data-toggle="modal" data-target="#myModal">update</a></td>
				<td>delete</td>
				</tr>
				
			</table>
			</center>
	    --%>
				       </div> 
				       
				     
				     
				     	 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-md">
    
     
      <div class="modal-content">
        <div class="modal-header" style="background-color:#90125E  ;">
          <button type="button" class="close" data-dismiss="modal" >&times;</button>
          <h4 class="modal-title" style="padding:10px;"><b>Student Details</b></h4> 
        </div>
        <div class="modal-body" style="background-color:black  ;">
			
			<div class="form-group" style="text-align:center;"><br>
			<table  style="color:black; border-color: black;" >
			<tr>
		   <!--  <td style="display:none;">Student ID:</td><td> -->
		    <input type="text" style="display:none;"  id="student_id" name="student_id" readonly="readonly"></td></tr> 
			
			<tr><td>Student Name:</td><td style="margin-top:-10px;"><input type="text"  id="student_name"  name="student_name" ></td></tr>
		
			<tr><td>Department:</td><td><input type="text"  id="department"  name="department" ></td></tr>
			
			<tr><td>Year:</td><td><input type="text"  id="year"  name="year" ></td></tr>
			
			<tr><td>Mobile No:</td><td><input type="text"  id="mobile"  name="mobile" ></td></tr>
			
			<tr><td>Address:</td><td><input type="text"  id="address"  name="address" ></td></tr>
			
			<tr><td>Email ID:</td><td><input type="email" id="email" name="email" ></td></tr>
			<!-- &nbsp;
			<tr><td>Password:</td><td><input type="text"  id="password"  name="password" ></td></tr> -->
			
			
			</table>
			</div><br>
			<div class="row">
		<center> <button type="button" class="btn btn-primary" style="margin-bottom:20px;width:120px;" onclick="updateDetails1()">Update Details</button></center> </div><br>
        </div>
        
      </div>
     
 </div></div></div>
 
<!--  
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        Modal Header
        <div class="modal-header" style="background-color:  #996600;">
          <h4 class="modal-title"><b style="margin-left:160px;font-size:35px;">Update Details</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        Modal body
        <div class="modal-body" style="background-color:   #C7AB73;">
         <form class="login">
               
                <div class="form-group">
                 <label style="color:Black;">Name:</label>   <input type="text" autocomplete="off" class="required form-control"  name="teacher_name" value="" style="color:#660033;">
                </div>
                <div class="form-group">
                  <label style="color:Black;">Phone No:</label>   <input type="text" autocomplete="off" class="required form-control"  name="contact_no" value="" style="color:#660033;">
                </div>
				 <div class="form-group">
                   <label style="color:Black;">Email-Id:</label>  <input type="text" autocomplete="off" class="required form-control"  name="email" value="" style="color:#660033;">
                </div>
                <div class="form-group">
                   <label style="color:Black;">Password:</label>  <input type="password" class="required form-control"  name="password" value="" style="color:#660033;">
                </div>
                
                <div class="form-group">
                    <label style="color:Black;">Branch:</label> <input type="text" autocomplete="off" class="required form-control"  name="branch" value="" style="color:#660033;">
                </div>
               
                <div class="form-group" style="background-color:   #C7AB73;">
                    <button type="submit" class="btn btn-success btn-lg1 btn-block" name="action" value="">Update</button>
                </div>
              
            </form>
		
        </div>
 
    </div>
  </div> 
				      
		          
				      

	 </div>       -->         
          
 

    
  		       
    <!--    </form> 
  -->
   <!-- JAVASCRIPTS --> 

</body>
</html>