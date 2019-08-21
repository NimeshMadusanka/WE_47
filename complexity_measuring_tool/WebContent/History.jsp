<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
 <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a href="#" class="navbar-brand">Complexity Measuring Tool</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="Home.jsp" class="nav-item nav-link active">Home</a>
                <a href="Home.jsp" class="nav-item nav-link">New Calculation</a>
                <a href="#" class="nav-item nav-link">History</a>
                <a href="#" class="nav-item nav-link">Feedback</a>
            </div>
                <input style="margin-left: 600px;" type="text" class="form-control mr-sm-2" placeholder="Search">
                <button type="submit" class="btn btn-outline-success">Search</button> 
        	</div>
    </nav>
    
    <form  action="HistoryController" enctype="multipart/form-data" method="POST">
  		<input type="file" name="file" multiple="true">
  		<p>Please select your file to see the history</p>
  		<button type="submit">Calculate Complexity</button>
	</form>

</body>
</html>