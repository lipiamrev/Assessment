<%@page import="com.manthan.shoppingapp.bean.ShoppingAppBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%
	ShoppingAppBean shoppingappbean = (ShoppingAppBean) request.getAttribute("orderproduct");
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

	<form action="./orderproduct" method="post">
		<table>
			<tr>
				<td>Product ID</td>
				<td>:</td>
				<td><input type="text" name="product_id" required></td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td>:</td>
				<td><input type="number" name="no_of_products" required></td>
			</tr>
			<br>
		</table>
	</form>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h3 style="color: red;">
		<%=msg%>
	</h3>
	<%
		}
	%>

	<%
		if (shoppingappbean != null) {
	%>
	<table>
		<tr>
			<td>Product ID</td>
			<td>:</td>
			<td><%=shoppingappbean.getProduct_id()%></td>
		</tr>
		<br>

		<tr>
			<td>Quantity</td>
			<td>:</td>
			<td><%=shoppingappbean.getProduct_name()%></td>
		</tr>
		<br>

		<tr>
			<td>Shipping Charges</td>
			<td>:</td>
			<td><%=shoppingappbean.orderSum()%></td>
	</table>
	<%
		}
	%>
</body>
</html>