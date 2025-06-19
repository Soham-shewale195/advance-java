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
import javax.servlet.http.HttpSession;


public class SessionServlet extends HttpServlet {

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
				   HttpSession session=req.getSession(true); // create sesion using this line 
				   session.setAttribute("user", user);
				   session.setAttribute("pass", pass);
				   out.print("Session Started");
				   out.print("session id : "+session.getId());
				   res.sendRedirect("GetSession");
				}
				else
				{
					out.println("<h1> Login fail</h1>");
					res.sendRedirect("Login.html");// redirect to login  page

				}
			
		}
		catch(Exception e1 )
		{
			System.out.println(e1.getMessage());
		}
	}

	private void getSession(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
