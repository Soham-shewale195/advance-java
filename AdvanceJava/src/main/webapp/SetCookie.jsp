<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // sciplet tag
	String user = request.getParameter("txtuser");
	String pass = request.getParameter("txtpass");
	
	
	try 
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
		
		PreparedStatement st=con.prepareStatement("select* from user where user=? and pass=?");
		st.setString(1, user);
		st.setString(2, pass);
		
		ResultSet rs=  st.executeQuery();				
			if(rs.next())
			{
				out.println("<h1> Login Succesfully</h1>");
				Cookie c1=new Cookie("user",user);
				Cookie c2=new Cookie("pass",pass);
				c1.setMaxAge(3600); // in sec 
				response.addCookie(c1);
				response.addCookie(c2);
				out.println("<h1> Cookie created. </h1>");
			}
			else
			{
				out.println("<h1> Login fail</h1>");
				response.sendRedirect("Login.html");

			}
		
	}
	catch(Exception e1 )
	{
		out.println(e1.getMessage());
	}
	%>
</body>
</html>