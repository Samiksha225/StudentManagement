<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<style>
form {
	background-color: #2196f347;
	border: 4px solid black
}
</style>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	
</script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<body>
	<div align="center">
		<h1>ADD NEW STUDENT INFORMATION</h1>
		<form action="add">
			<p>
				First Name:- <input type="text" id="p1" name="first_name"
					placeholder="enter first name" required="required"
					onkeypress='return event.charCode >= 65 && event.charCode <= 90 ||  event.charCode >= 97 && event.charCode <= 122'><br>
			<p>
				Last Name:- <input type="text" name="last_name"
					placeholder="enter last name"  required="required"
					onkeypress='return event.charCode >= 65 && event.charCode <= 90 ||  event.charCode >= 97 && event.charCode <= 122'><br>
			<p>
				Email Id:- <input type="email" name="email" value=" "
					placeholder="enter email id"  required="required">
			<p>
				Mobile Number:- <input type="text" id="txtNumeric" name="mobile" minlength="10" maxlength="13" required="required"
					placeholder="enter mobile number" >
			<p>
				Gender:-  Male <input type="radio" name="gender" value="male">
				Female<input type="radio" name="gender" value="female"  required="required">
			<p>
				Date of Birth:- <input type="date" name="date_of_birth"
					placeholder="enter date of birth"  required="required">
			<p>
			Software Skills:- <input type="checkbox" name="softwareSkills" value="java">Java<br>
							<input type="checkbox" name="softwareSkills" value="javascript">JavaScript<br>
							<input type="checkbox" name="softwareSkills" value="html">HTML<br>
							<input type="checkbox" name="softwareSkills" value="css">CSS<br>
							<input type="checkbox" name="softwareSkills" value="bootstrap">Bootstrap<br>
							<input type="checkbox" name="softwareSkills" value="jquery">Jquery<br>
			
				<p><button type="submit">submit</button>
	</div>
	<script
            src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	
	<script type="text/javascript">
            $(function() {
                $('#txtNumeric').keydown(
                        function(e) {
                            var key = e.keyCode;
                            if ((key == 32) || (key == 46)
                                    || (key >= 35 && key <= 40)
                                    || (key >= 65 && key <= 90))
                                e.preventDefault();
                        });



           });
        </script>
</body>
</html>
