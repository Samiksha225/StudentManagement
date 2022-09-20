<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<style>
body {
	background-color: #2196f347;
	border: 1px solid black;
	border-width: 20px 20px;
}
</style>
<body>
	<div align="center">
		<h1>STUDENT DASHBOARD</h1>
		<table id="mytable">
			<thead>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email ID</th>
					<th>Mobile Number</th>
					<th>Gender</th>
					<th>Date Of Birth</th>
					<th>Software Skills</th>
					<th>Action</th>
					<th><button type="submit" form="deletemultiplestudent"
							name="multipledelete" class="btn btn-danger">Multiple
							Delete</button>
						<form action="multipledelete" id="deletemultiplestudent"></form></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentList}" var="s" varStatus="varstatus">
					<tr>
						<td>${s.studentId }</td>
						<td>${s.firstName }</td>
						<td>${s.lastName }</td>
						<td>${s.email }</td>
						<td>${s.mobile}</td>
						<td>${s.gender }</td>
						<td>${s.dateOfBirth }</td>
						<td>${s.softwareSkills }</td>
						<td><button>
								<a href="delete?studentId=${s.studentId }"
									onclick='return deleteRecord()'><i class="fa fa-trash-o"></i></a>
							</button>
							<button>
								<a href="update?studentId=${s.studentId }"
									onclick="updateRecord()"><i class="fa fa-edit"></i></a>
							</button>
						<td><center>
								<input type="checkbox" form="" name="deletemultiplestudent"
									value="${s.studentId }" class="click"
									count="${varstatus.count }">
							</center></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<button>
				<a href="addStudent" onclick='return addRecord()'>ADD STUDENT <i
					class="fa fa-plus"></i></a>
			</button>
	</div>

	<script>
		function updateRecord() {
			alert("Do you want to update the record?");
		}

		function deleteRecord() {
			return confirm("Do you want to delete the record?");
		}

		function addRecord() {
			return confirm("Do you want to add the record?");
		}
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			if (!(`${message}` === ""))
				swal(`${message}`, `${data}`, `${icon}`);
		});
	</script>
	<script>
		$(document).ready(function() {
			$('#mytable').DataTable();
		});
	</script>
	<script>
		$('.click').change(function() {
			$(this).attr('form', 'deletemultiplestudent');

		})
	</script>
</body>
</html>