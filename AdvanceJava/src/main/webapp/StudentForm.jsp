<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String rollno = request.getParameter("txtroll");
	String name = request.getParameter("txtname");
	String phoneno = request.getParameter("txtphone");
	String city = request.getParameter("txtcity");
	String email = request.getParameter("txtemail");

	

	try 
	{
		// database connectivity
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");


		// operation perform on database 
		PreparedStatement st = con.prepareStatement("INSERT INTO studentinfo VALUES (?, ?, ?, ?, ? )"); // (?) is used to pass runtime values in database in praticular columns

		// PreparedStatement st=con.prepareStatement("insert into studentinfo values(?,?,?");
		
		st.setString(1, rollno);
		st.setString(2, name);
		st.setString(3, phoneno);
		st.setString(4, city);
		st.setString(5, email);
		

		int rows = st.executeUpdate();			
		if (rows > 0) 
		{
			out.println("<h1>Data inserted successfully</h1>");
			response.sendRedirect("StudentForm.html");  // redirect to student information form
			//RequestDispatcher rd = request.getRequestDispatcher("StudentForm.html");
			//rd.include(request, response);

		} 
		else 
		{
			out.println("<h1>Insertion failed</h1>");
		}


	}
	catch(Exception e1 )
	{
		out.println(e1.getMessage());
	}
	%>
</body>
</html>