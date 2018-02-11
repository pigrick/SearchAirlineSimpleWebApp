<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight List</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="navigation.jsp" />
	<br/>
	<div class="container">       
    <table class="table table-dark table-striped table-bordered table-sm">
      <thead>
        <tr>
          <th>Airline Name</th>
          <th>Flight No</th>
          <th>Origin</th>
          <th>Destination</th>
          <th>Date of Departure</th>
          <th>Time of Departure</th>
          <th>Date of Arrival</th>
          <th>Time of Arrival</th>
        </tr>
      </thead>
      <tbody>
      <c:if test="${flights.size() == '0'}">
      	<tr>
      		<td colspan="8">
                Unable to find result!
             </td>
      	</tr>
      </c:if>
      <c:forEach var="flight" items="${flights}">
        <tr>
          <td>${flight.airline}</td>
          <td>${flight.flightNo}</td>
          <td>${flight.origin}</td>
          <td>${flight.destination}</td>
          <td><fmt:formatDate type="date" value="${flight.timeDeparture}" /></td>
          <td><fmt:formatDate type="time" timeStyle="short" value="${flight.timeDeparture}" /></td>
          <td><fmt:formatDate type="date" value="${flight.timeArrival}" /></td>
          <td><fmt:formatDate type="time" timeStyle="short" value="${flight.timeArrival}" /></td>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>