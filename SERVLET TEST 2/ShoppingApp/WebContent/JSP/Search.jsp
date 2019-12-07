<%@page import="com.manthan.shoppingapp.bean.ShoppingAppBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	ShoppingAppBean shoppingappbean = (ShoppingAppBean) request.getAttribute("searchproduct");
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
	<h3>Search by Product Name</h3>
	<form action="./productsearch" method="get">
		Product Name: <input type="text" name="product_name" placholder="eg: table,chair, stool, central-table" required>
		<br> <br> <input type="submit" value="Search">
	</form>
	<br>

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
			<td>Product Name</td>
			<td>:</td>
			<td><%=shoppingappbean.getProduct_name()%></td>
		</tr>
		<br>

		<tr>
			<td>Product Color</td>
			<td>:</td>
			<td><%=shoppingappbean.getProduct_color()%></td>
		</tr>
		<br>

		<tr>
			<td>Description</td>
			<td>:</td>
			<td><%=shoppingappbean.getDescription()%></td>
		</tr>
		<br>

		<tr>
			<td colspan="3"><br> <a href="./orderproduct">Order</a><br></td>
		</tr>

	</table>
	<%
		}
	%>

</body>
</html>