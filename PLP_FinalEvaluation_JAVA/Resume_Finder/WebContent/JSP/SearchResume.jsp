<%@page import="java.util.List"%>
<%@page import="com.manthan.resume.bean.Resumebean"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("message");
%>

<%
	List<Resumebean> file = (ArrayList) request.getAttribute("filelist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./uploadResume" style="margin-left: 90%">Upload Resume</a>

	<div align="center">
		<h2>Search Resume</h2>
	</div>
	<br>
	<form action="./resumeSearch" method="GET" style="margin-left: 42%">
		<input type="text" placeholder="Search" name="searchfile"> <input
			type="submit" value="Search">
	</form>


	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<%=msg%>
	<%
		}
	%>
	<%
		if (file != null) {
	%>

	<table border="1" padding="200px">
		<tr>
			<th>FileName</th>
			<th>Name</th>
			<th>Email_ID</th>
			<th>Download link</th>
		</tr>
		<%
			for (Resumebean bean : file) {
		%>

		<tr>
			<td><%=bean.getFile_name()%></td>&nbsp;
			<td><%=bean.getName()%></td>&nbsp;
			<td><%=bean.getEmail()%></td>&nbsp;
			<td><a href="./DownloadLink?file="<%=bean.getFile_name() %>>Download here</a></td>

		</tr>
		<%
			}
		%>
		<%
			}
		%>
	</table>

</body>
</html>