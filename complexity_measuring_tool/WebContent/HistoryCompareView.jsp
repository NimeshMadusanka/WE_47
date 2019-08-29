<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History Compare</title>
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
					href="History.jsp" class="nav-item nav-link">History</a> <a href="#"
					class="nav-item nav-link">Feedback</a>
			</div>
			<input style="margin-left: 600px;" type="text"
				class="form-control mr-sm-2" placeholder="Search">
			<button type="submit" class="btn btn-outline-success">Search</button>
		</div>
	</nav>
	<div style="float: left; width: 100%; height: 75%; padding: 10px">
		<div class="leftDiv" style="overflow-y: scroll; height: 400px; float: left; margin-right: 5px; width: 45%; background-color: white;">
			<div style="float: left;">
			<c:set var="count" value="0" scope="page" />
			<table>
				<thead><h2>${fileName} -</h2><h3>${datTime}</h3> 
					<tr>
						<th scope="col">#</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${newFilelineList}" var="line">
					<tr>
						<c:set var="count" value="${count + 1}" scope="page"/>
						<th scope="row">${count}</th>
						<td><c:out value="${line}"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<div style="float: left;">
				<h4>Complexity Type value : ${new_ctc}</h4>
				<h4>Complexity Inheritance value : ${new_tci}</h4>
				<h4>Complexity Nesting value : ${new_cnc}</h4>
				
				<h4>Total Complexity value : ${new_ctc+new_tci+new_cnc}</h4>
			</div>
		</div>
		<div class="rightDiv" style="overflow-y: scroll; height: 400px; float: left; width: 45%; background-color: white;">
			<div style="float: left;">
			<c:set var="count1" value="0" scope="page" />
			<c:if test="${oldFileNotFound == 'false'}">
			<table>
				<thead><h2>${fileName} -</h2><h3>${old_datTime}</h3> 
					<tr>
						<th scope="col">#</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${oldFilelineList}" var="line1">
					<tr>
						<c:set var="count1" value="${count1 + 1}" scope="page"/>
						<th scope="row">${count1}</th>
						<td><c:out value="${line1}"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</c:if>
			</div>
			<div style="float: left;">
			<c:if test="${oldFileNotFound == 'false'}">
				<h4>Old complexity Type value : ${old_ctc}</h4>
				<h4>Old complexity Inheritance value : ${old_tci}</h4>
				<h4>Old complexity Nesting value : ${old_cnc}</h4>
				
				<h4>Total Old complexity value : ${old_ctc+old_tci+old_cnc}</h4>
			</c:if>
			</div>
			
			<c:if test="${oldFileNotFound == 'true'}">
			<h2>Sorry, No such file found in previous calculations...</h2>
			</c:if>
		</div>
	</div>


</body>
</html>