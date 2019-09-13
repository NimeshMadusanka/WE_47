<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History Compare</title>
</head>
<body>
	
	<jsp:include page="menuBar.jsp"></jsp:include>
	
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