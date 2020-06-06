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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
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
.year {
  background: rgba(255,255,255,0.1);
  border: none;
  font-size: 16px;
  height: auto;
  margin: 0;
  outline: 0;
  padding: 15px;
  width: 50%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
  margin-bottom: 30px;
  float:left;
}
.sem {
  background: rgba(255,255,255,0.1);
  border: none;
  font-size: 16px;
  height: auto;
  outline: 0;
  padding: 15px;
  width: 50%;
  background-color: #e8eeef;
  color: #8a97a0;
  box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
  margin-bottom: 30px;
}
ul li{
font-size:15px;
}
</style>   
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
 function validator()
 {
 

     
    re = /^\d{10}$/;
    if(!re.test(myForm.mobile.value)) {
      alert("Error: mobile number must contain number (0-9)!");
      document.myForm.mobile.focus();
      return false;
    }
   
   

    var emailID = document.myForm.email.value;
    atpos = emailID.indexOf("@");
    dotpos = emailID.lastIndexOf(".");
    if(emailID=="")
    {
   		 alert( "please provide email ID" );
            document.myForm.email.focus() ;
            return false;       
     }
    if (atpos < 1 || ( dotpos - atpos < 2 )) 
    {
       alert("Please enter correct email ID.")
       document.myForm.email.focus() ;
       return false;
    }
   
  
  
   
 }
</script>     
<!-- <script type="text/javascript">

function Validation()
{
var a = document.form.phone.value;
if(a=="")
{
alert("please Enter the Contact Number");
document.form.phone.focus();
return false;
}
if(isNaN(a))
{
alert("Enter the valid Mobile Number(Like : 9566137117)");
document.form.phone.focus();
return false;
}
if((a.length < 10) || (a.length > 10))
{
alert("Invalid mobile number");
document.form.phone.select();
return false;
}
}

</script>    -->    

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
       <!--  <li class="active"><a href="home.jsp">Home</a></li> -->
       <!--  <li><a href="login.jsp">Admin Login</a></li>
        <li><a href="login.jsp">Staff Login</a></li>
        <li><a href="login.jsp">Student Login</a></li> -->
        <!--  <li><a href="stafftoStudent.jsp">Back</a></li> -->
        <li><a href="LogoutServlet">Log out</a></li>
      </ul>
      <!-- ################################################################################################ --> 
    </nav>
  </div>
</div>
<!-- ################################################################################################ -->       
      <form action="UserServlet" method="post" name="myForm" onsubmit="return validator();">
      
        <h1>Student Registration</h1>
        
        <fieldset>
        
          <legend><span class="number"></span>Your basic info</legend>
          
           <label>
        	<%
				String staffexist=(String)request.getAttribute("staffexist");
        	
				if(staffexist!=null)
				out.println("<font color=red size=4px>"+staffexist+"</font>");		
			%>
		</label>     
         <label>
        <%
		String loginmsg=(String)request.getAttribute("error");
		if(loginmsg!=null)
		out.println("<font color=green size=4px>"+loginmsg+"</font>");		
		%>
		</label>
        <label for="job">Role:</label>
       <!--  <select id="job" name="role">
           <option value="Student">Student</option>
        </select> -->
        
         
        <input type="text" id="name" name="role" value="Student" readonly="readonly">
        
          <label for="name">Name:</label>
          <input type="text" id="name" name="name" required="" placeholder="Name">
          
          <label for="name">Enrollment No:</label>
         <input type="text" id="enrollment"  name="enrollment">
          
          <label for="name">Department:</label>
         <input type="text" id="department"  name="department">
         <!--  <input type="text" id="name" name="department" required="" placeholder="IT"> -->
          
          <label for="name">Year:</label>
          
          <!--  <select class="year" name="year" required=""> -->
           <select class="year" style="width:400px;" name="year" required="">
           <option value="F.Y.">F.Y. </option>
        	<option value="S.Y.">S.Y. </option>
        	<option value="T.Y.">T.Y. </option>
        <!-- 	<option value="B.E ">B.E </option> -->
	  </select>
          <!-- <optgroup label="year">
        	<option value="F.Y.">F.Y. </option>
        	<option value="S.Y.">S.Y. </option>
        	<option value="T.Y.">T.Y. </option>
        	<!-- <option value="B.E ">B.E </option> -->
        	</optgroup>
        	</select> 
        	 <select class="sem" name="sem" required="">
        	 <optgroup label="semester">
        	 <option value="sem I ">sem I </option>
        	 <option value="sem II ">sem II </option>
        	 <option value="sem III ">sem III </option>
        	<option value="sem IV ">sem IV </option>
        	<option value="sem V">sem V </option>
        	<option value="sem VI">sem VI </option>
        	
        	</optgroup>
        	</select> 
          </br>
          <label for="name">Mobile No:</label>
          <input type="text" id="mobile" name="mobile" requried="" placeholder="+91">
          
          <label for="name">Address:</label>
          <textarea id="address" rows="4" cols="50" name="address" required=""></textarea>
          
          <label for="mail">Email:</label>
          <input type="email" id="email" name="email" required="" placeholder="xyz@gmail.com">
          
              	
          
        </fieldset>
        <button type="submit" name="action" value="Register" >Sign Up</button>
      </form>
      
   <!-- JAVASCRIPTS --> 
<script src="layout/scripts/jquery.min.js"></script> 
<script src="layout/scripts/jquery.fitvids.min.js"></script> 
<script src="layout/scripts/jquery.mobilemenu.js"></script> 
<script src="layout/scripts/tabslet/jquery.tabslet.min.js"></script>
</body>
</html>