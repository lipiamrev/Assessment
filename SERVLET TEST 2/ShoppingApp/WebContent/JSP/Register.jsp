<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<form action="./userregisterr" method="post">
		<table>

			<tr>
				<td>UserID</td>
				<td>:</td>
				<td><input type="text" name="user_id" required></td>
			</tr>
			
			<tr>
				<td>Username</td>
				<td>:</td>
				<td><input type="text" name="user_name" required></td>
			</tr><br>

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
				<td colspan="3"><br> <input type="submit" value="Register"></td>
			</tr><br>

			<tr>
				<td colspan="3"><br> <a href="./userlogin">Login</a><br></td>
			</tr>

		</table>
	</form>

</body>
</html>