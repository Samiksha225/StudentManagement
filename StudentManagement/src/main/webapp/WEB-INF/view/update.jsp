<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
<head>
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
</head>
<body>
	<div align="center">
		<h1>UPDATE STUDENT INFORMATION</h1>
		<form action="update" method="post">
			<input type="hidden" name="studentId" value="${student.studentId }">
			<p>
				First Name:- <input type="text" name="first_name"
					value="${student.firstName }">
			<p>
				Last Name:- <input type="text" name="last_name"
					value="${student.lastName }">
			<p>
				EmailId:- <input type="text" name="email" value="${student.email }">
			<p>
				Mobile Number:- <input type="text" name="mobile"
					value="${student.mobile }">
			<p>
				Gender:- <input type="text" name="gender" value="${student.gender }">
			<p>
				Date Of Birth:- <input type="date" name="date_of_birth"
					value="${student.dateOfBirth }">
			<p>
			Software Skills:- <input type="checkbox" name="softwareSkills" value="java">Java<br>
							<input type="checkbox" name="softwareSkills" value="javascript">JavaScript<br>
							<input type="checkbox" name="softwareSkills" value="html">HTML<br>
							<input type="checkbox" name="softwareSkills" value="css">CSS<br>
							<input type="checkbox" name="softwareSkills" value="bootstrap">Bootstrap<br>
							<input type="checkbox" name="softwareSkills" value="jquery">Jquery<br>
							
			<p>	<button type="submit">Update</button>
	</div>

	</form>

</body>
</html>
