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
	
	String name = request.getParameter("txtname");
	int id = Integer.parseInt(request.getParameter("intID"));
	float price = Float.parseFloat(request.getParameter("floatprice"));
	String company = request.getParameter("txtcompany");

	

	try 
	{
		// database connectivity
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");


		// operation perform on database 
		PreparedStatement st = con.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ? )"); // (?) is used to pass runtime values in database in praticular columns

		// PreparedStatement st=con.prepareStatement("insert into studentinfo values(?,?,?");
		
		st.setString(1, name);
		st.setInt(2, id);
		st.setFloat(3, price);
		st.setString(4, company);
		
		

		int rows = st.executeUpdate();			
		if (rows > 0) 
		{
			out.println("<h1>Data inserted successfully</h1>");
			response.sendRedirect("DisplayProduct.jsp");  // redirect to student information form

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