<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Product Info</title>
</head>
<body>
	<h1 style="text-align: center">Product Details Form :</h1>
	<%@include file="ProductForm.html"%>

	<h1 style="text-align: center">Product Detail Table :</h1>
	
	<div style="display:flex; justify-content:center">
		<table border="2">
			<tr>
				<th>Name</th>
				<th>ID</th>
				<th>Price</th>
				<th>Company</th>
			</tr>
			<%
			// scriplet tage used to write java code in it.
			try {
				Class.forName("com.mysql.jdbc.Driver");// install Driver 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

				PreparedStatement st = con.prepareStatement("select* from product");
				ResultSet re = st.executeQuery();

				while (re.next()) {
					out.println("<tr><td>" + re.getString(1) + "</td><td>" + re.getInt(2) + "</td><td>" + re.getFloat(3)
					+ "</td><td>" + re.getString(4) + "</td></tr>");
				}

			} catch (Exception e) {
				out.println(e.getMessage());
			}
			%>
		</table>
	</div>
</body>
</html>