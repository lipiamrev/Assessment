<%@page import="com.manthan.servlet.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%UserBean userBean = (UserBean) session.getAttribute("userBean"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3 style="color: navy;">
		Hello
		<%=userBean.getUsername()%>!
	</h3>

	<a href="./logout">Logout</a>
	<br>
</body>
</html>