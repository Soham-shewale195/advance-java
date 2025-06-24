<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Student Detail Table :</h1>
	<table border="2">
		<tr>
			<th>Rollno</th>
			<th>Name</th>
			<th>perc</th>
		</tr>
		<%
		try {
			Class.forName("com.mysql.jdbc.Driver");// install Driver 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

			PreparedStatement st = con.prepareStatement("select* from student");
			ResultSet re = st.executeQuery();

			while (re.next()) {
				out.println("<tr><td>" + re.getInt(1) + "</td><td>" + re.getString(2) + "</td><td>" + re.getFloat(3)+"</td></tr>");
			}

		} catch (Exception e) {
			out.println(e.getMessage());
		}
		%>
	</table>
</body>
</html>