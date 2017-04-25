<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Application: Movie List</title>
<meta name="description" content="This is a JSP example that demostrates how to output
	every movie in our Excel spreadsheet to a web page.">
<%@include file="includes/styles.jsp" %>
</head>
<body>

<div class="container">
	<div class="hero-unit">
	 <h1>Movies List</h1>
	</div>
	<%@include file="includes/navigation.jsp" %>
	<div class="container">
		<!-- Output the class list -->
		<c:choose>
			<c:when test="${empty movieName}">
				<p>Sorry, the list of movie names is empty</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="movieName" items="${movieName}">
					<div class="span">
						<h2>${movieName.title}</h2>
						<p>${movieName.director} duration is ${movieName.lengthInMinutes} minutes</p>
					</div> 
				</c:forEach>
			</c:otherwise> 
		</c:choose>
	</div>
	<%@include file="includes/footer.jsp" %>
</div>
<%@include file="includes/scripts.jsp" %>
</body>
</html>