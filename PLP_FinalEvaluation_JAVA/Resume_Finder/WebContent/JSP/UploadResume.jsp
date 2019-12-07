<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String msg = (String) request.getAttribute("message"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./searchResume" style="margin-left: 90%">Search Resume</a>

	<div align="center">
		<h2>Upload Resume</h2>
	</div>
	<br>
	<form action="./resumeUpload" method="POST" style="margin-left: 42%" enctype="multipart/form-data">
		<input type="file" name="upload">
		<input type="submit" value="Upload">
	</form>
	
	<% if(msg != null && !msg.isEmpty()) { %>
	<h3 style="color: red;"> <%=msg %> </h3>
	<%} %>
	
</body>
</html>