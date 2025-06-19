package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentForm extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();


		int rollno = Integer.parseInt(req.getParameter("txtroll"));
		String name = req.getParameter("txtname");
		String phoneno = req.getParameter("txtphone");
		String city = req.getParameter("txtcity");
		String email = req.getParameter("txtemail");

		

		try 
		{
			// database connectivity
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");


			// operation perform on database 
			PreparedStatement st = con.prepareStatement("INSERT INTO studentinfo VALUES (?, ?, ?, ?, ? )"); // (?) is used to pass runtime values in database in praticular columns

			// PreparedStatement st=con.prepareStatement("insert into studentinfo values(?,?,?");
			
			st.setInt(1, rollno);
			st.setString(2, name);
			st.setString(3, phoneno);
			st.setString(4, city);
			st.setString(5, email);
			

			int rows = st.executeUpdate();			
			if (rows > 0) 
			{
				out.println("<h1>Data inserted successfully</h1>");
				//res.sendRedirect("StudentForm.html");  // redirect to student information form
				RequestDispatcher rd=req.getRequestDispatcher("StudentForm.html");
				rd.include(req, res);

			} 
			else 
			{
				out.println("<h1>Insertion failed</h1>");
			}


		}
		catch(Exception e1 )
		{
			System.out.println(e1.getMessage());
		}
	}

}
