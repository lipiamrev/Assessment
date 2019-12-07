<%@page import="com.manthan.shoppingapp.bean.ShoppingAppBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ShoppingAppBean shoppingappBean = (ShoppingAppBean) session.getAttribute("shoppingappbean");
%>
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

	<form action="./userloginn" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td>:</td>
				<td><input type="email" name="email" required></td>
			</tr><br>

			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" required></td>
			</tr><br>

			<tr>
				<td colspan="3"><br> <input type="submit" value="Login"></td>
			</tr>

			<tr>
				<td colspan="3"><br> <a href="./userregister">Register</a><br></td>
			</tr>
		</table>
	</form>

</body>
</html>