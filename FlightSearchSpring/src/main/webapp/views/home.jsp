<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<br/>
	<div class="container centerlize">
		<div class="jumbotron bgi">
			<h1>Search Flight:</h1>
			<br />
			<div class="container">
				<form class="form-inline" action="/flights/search" method="get">
					<div class="form-group">
						<input type="text" name="origin" class="form-control mr-sm-2"
							placeholder="Origin">
					</div>
					<div class="form-group">
						<input type="text" name="destination" class="form-control mr-sm-2"
							placeholder="Destination">
					</div>
					<div class="form-group">
						<input type="date" name="timeDeparture"
							class="form-control mr-sm-2">
					</div>
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>