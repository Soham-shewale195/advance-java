package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Cookiesevlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();
		String user = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		
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
					res.addCookie(c1);
					res.addCookie(c2);
					out.println("<h1> Cookie created. </h1>");
				}
				else
				{
					out.println("<h1> Login fail</h1>");
					res.sendRedirect("Login.html");

				}
			
		}
		catch(Exception e1 )
		{
			System.out.println(e1.getMessage());
		}
	}
}
