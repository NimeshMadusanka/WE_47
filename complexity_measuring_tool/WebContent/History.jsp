<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
.bs-example {
	margin: 20px;
}

.navbar {
	margin-bottom: 1rem;
}

body {
	background: rgba(0, 0, 0, 0.9);
}

form {
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -100px;
	margin-left: -250px;
	width: 500px;
	height: 200px;
	border: 4px dashed #fff;
}

form p {
	width: 100%;
	height: 100%;
	text-align: center;
	line-height: 170px;
	color: #ffffff;
	font-family: Arial;
}

form input {
	position: absolute;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	outline: none;
	opacity: 0;
}

form button {
	margin: 0;
	color: #fff;
	background: #16a085;
	border: none;
	width: 508px;
	height: 35px;
	margin-top: -20px;
	margin-left: -4px;
	border-radius: 4px;
	border-bottom: 4px solid #117A60;
	transition: all .2s ease;
	outline: none;
}

form button:hover {
	background: #149174;
	color: #0C5645;
}

form button:active {
	border: 0;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a href="#" class="navbar-brand">Complexity Measuring Tool</a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav">
				<a href="Home.jsp" class="nav-item nav-link active">Home</a> <a
					href="Home.jsp" class="nav-item nav-link">New Calculation</a> <a
					href="#" class="nav-item nav-link">History</a> <a href="#"
					class="nav-item nav-link">Feedback</a>
			</div>
			<input style="margin-left: 600px;" type="text"
				class="form-control mr-sm-2" placeholder="Search">
			<button type="submit" class="btn btn-outline-success">Search</button>
		</div>
	</nav>

	<form action="HistoryController" enctype="multipart/form-data"
		method="POST">
		<input type="file" name="file" multiple="true">
		<p>Please select your file to see the history</p>
		<button type="submit">Calculate Complexity and Compare</button>
	</form>

</body>
</html>

<script>

$(document).ready(function(){
	
	  $('form input').change(function () {
	    $('form p').text(this.files.length + " file(s) selected");
	  });
	});
	
</script>