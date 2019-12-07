<%@page import="com.manthan.servlet.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%UserBean userBean = (UserBean) session.getAttribute("userBean"); %>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null) {
	%>
	<%=msg%>
	<%
		}
	%>

	<form action="./login" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td>:</td>
				<td><input type="text" name="username" required></td>
			</tr>

			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required></td>
			</tr>

			<tr>
				<td colspan="3"><br> <input type="submit" value="Login"></td>
			</tr>

			<tr>
				<td colspan="3"><br>
				<a href="./forgot">Forgot Password</a><br></td>
			</tr>

			<tr>
				<td colspan="3"><br>
				<a href="./register">Register</a><br></td>
			</tr>
		</table>
	</form>

</body>
</html>