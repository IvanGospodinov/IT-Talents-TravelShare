<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login/Register Form</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<script type="text/javascript">
	
	function RefreshEmail() {
		var email = $("#email").val();
		$.get("http://localhost:8080/ShareTravel/CheckForEmail?email=" + email,
				function(data) {
					console.log(data);
		});
				
	}
	
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>
	<label> Enter email: </label>
	<form action=""></form>
	<input type="text" id="email" alert="RefreshEmail()" size=18 maxlength=50 required>submit>
 <button type="submit" onkeyup="RefreshEmail()" size=18 maxlength=50 required>submit</button>

</body>

</html>
