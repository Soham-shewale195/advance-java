package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Signup extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		String user = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			
			PreparedStatement st=con.prepareStatement("insert into user values(?,?)");
			st.setString(1, user);
			st.setString(2, pass);
			
			int n = st.executeUpdate();				
				
					out.println(n+"<h1> Login Succesfully</h1>");
					res.sendRedirect("Login.html");
				
			
		}
		catch(Exception e1 )
		{
			System.out.println(e1.getMessage());
		}
	}
}
