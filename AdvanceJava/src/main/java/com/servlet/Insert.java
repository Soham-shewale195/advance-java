package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Insert extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out=res.getWriter();


		int Rollno = Integer.parseInt(req.getParameter("roll"));
		String name = req.getParameter("name");
		float percentage = Float.parseFloat(req.getParameter("perc"));

		try 
		{
			// database connectivity
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");


			// operation perform on database 
			PreparedStatement st = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?)"); // (?) is used to pass runtime values in database in praticular columns

			// PreparedStatement st=con.prepareStatement("insert into student values(?,?,?");
			
			st.setInt(1, Rollno);
			st.setString(2, name);
			st.setFloat(3, percentage);

			int rows = st.executeUpdate();			
			if (rows > 0) 
			{
				out.println("<h1>Data inserted successfully</h1>");
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
