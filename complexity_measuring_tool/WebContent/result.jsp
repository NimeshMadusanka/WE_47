<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<jsp:include page="menuBar.jsp"></jsp:include>

	<c:set var="count" value="0" scope="page" />
	<table
		class="table table-dark table-striped table-bordered table-hover">
		<thead>
			<h2>Result</h2>
			</h3>
			<tr>
				<th scope="col">#</th>
				<th scope="col">File Name</th>
				<th scope="col">Date Time</th>
				<th scope="col">CS</th>
				<th scope="col">CNS</th>
				<th scope="col">CTS</th>
				<th scope="col">CI</th>
				<th scope="col">CR</th>
				<th scope="col">TW</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:set var="count" value="${count + 1}" scope="page" />
				<th scope="row">${count}</th>
				<td><c:out value="${fileName}" /></td>
				<td><c:out value="${date}" /></td>
				<td><c:out value="${cs}" /></td>
				<td><c:out value="${cns}" /></td>
				<td><c:out value="${ctc}" /></td>
				<td><c:out value="${tci}" /></td>
				<td><c:out value="${cr}" /></td>
				<td><c:out value="${tc}" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>