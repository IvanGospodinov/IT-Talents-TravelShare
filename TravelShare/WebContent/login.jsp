<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login/Register Form</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link rel="stylesheet" href="css/styleLogin.css">
 
</head>

<body>
	<!-- If the user has logged in redirect to the index page -->
	<c:if test="${ sessionScope.user != null }">
			<c:redirect url="index.jsp"></c:redirect>
		</c:if>
		
	<h1 style="font-style: oblique;text-align: center;"></h1><br/>	

	<div class="login-page">
		<div class="form">
			<!-- Register part -->
	  <form class="register-form" action="Register" method="post" enctype="multipart/form-data">
      <input type="text" name="uname" placeholder="username"/>
      <input id="email" type="email" name="user_email" placeholder="email address" onkeyup="return sendInfo()"/>
      <input id="password" type="password" name="password" placeholder="password"/>
      <input id="conpassword" type="password" name="conpassword" placeholder="confirm password"/>
      <input type="text" name="user_firstname" placeholder="first name"/>
      <input type="text" name="user_lastname" placeholder="last nname"/>
      <input type="file" name="user_pictureURL" placeholder="avatar" />
      <button type="submit" >create</button><p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>

			<!-- Login part -->
			<form class="login-form" action="login" method="post">
				<input type="email" placeholder="email" name="user_email" /> 
				<input type="password" placeholder="password" name="password" />
				<button type="submit">login</button>
				<p class="message">
				Not registered? <a href="#">
				Create an account</a>
				</p>
			</form>
		</div>
	</div>


	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>

</body>
</html>