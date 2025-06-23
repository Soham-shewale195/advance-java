<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String user = request.getParameter("txtuser");
	String pass = request.getParameter("txtpass");
	
	
	try 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
		
		PreparedStatement st=con.prepareStatement("insert into user values(?,?)");
		st.setString(1, user);
		st.setString(2, pass);
		
		int n = st.executeUpdate();				
			
				out.println(n+"<h1> Login Succesfully</h1>");
				response.sendRedirect("Login.html");
			
		
	}
	catch(Exception e1 )
	{
		out.println(e1.getMessage());
	}
	%>
</body>
</html>