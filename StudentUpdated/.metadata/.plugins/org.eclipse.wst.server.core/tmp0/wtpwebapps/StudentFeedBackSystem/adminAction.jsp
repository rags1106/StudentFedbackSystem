<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Student Feedback System</title>
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
<div class="wrapper row2">
  <div class="rounded">
    <nav id="mainav" class="clear"> 
      <ul class="clear">
       <!--  <li class="active"><a href="home.jsp">Home</a></li> -->
        <li><a href="LogoutServlet">Log out</a></li>
      </ul>
    </nav>
  </div>
</div>
<br>
<br>
      <form>
      
        
        <fieldset>
          <legend><span class="number"></span>Registration</legend>
        
      <button><a href="addsubject.jsp" style="color:black; text-decoration:none;">Add Subject</a></button>
       
       <br>
       <br>
       
          
        
       <button><a href="register.jsp" style="color:black; text-decoration:none;">Add Staff</a></button>
       
       <br>
       <br>
        
        
            <button><a href="UserServlet?action=alluserlist" style="color:black; text-decoration:none;">View Staff Feedback</a></button>
          
          <br>
       <br>
        
        
            <button><a href="UserServlet?action=allStudentlist" style="color:black; text-decoration:none;">View All Student</a></button>
            
      </form>
      
  
      
  
       
   <!-- JAVASCRIPTS --> 
<script src="layout/scripts/jquery.min.js"></script> 
<script src="layout/scripts/jquery.fitvids.min.js"></script> 
<script src="layout/scripts/jquery.mobilemenu.js"></script> 
<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
</body>
</html>