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


public class SetUpdatepass extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String user = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");


		try 
		{

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");

			PreparedStatement st = con.prepareStatement("UPDATE user SET pass=? WHERE user=?");
			st.setString(1, pass);
			st.setString(2, user);

			int rows = st.executeUpdate();

			if (rows > 0)
			{
				out.println("<h3>Password updated successfully!</h3>");
				res.sendRedirect("Login.html");
			}
			else 
			{
				out.println("<h3>Update failed: User not found.</h3>");
			}		


		}
		catch(Exception e1 )
		{
			System.out.println(e1.getMessage());
		}
	}
}
